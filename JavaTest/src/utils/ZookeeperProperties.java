package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 读取zookeeper中的配置信息
 *
 * @author ：BHT
 * @date ：2019-07-12 15:16
 */
public class ZookeeperProperties {

    /**
     * zookeeper地址
     */
    private static final String CONNECTION_URL = "172.31.87.205:2181";
    /**
     * session失效时间
     */
    private static final int SESSION_TIMEOUT = 100000;
    /**
     * 查询目录
     */
    private static final String ROOT_PATH = "/gy/financeonsconsumerv1";
    /**
     * 使用参数查询时，是否查询全部配置文件
     * 如果选择false，则碰到第一个符合的值就退出程序
     */
    private static final boolean FULL_QUERY = true;
    /**
     * 结果输出到某文件
     */
    private static final String OUT_PATH = "/Users/bay/Downloads/Untitled-1";
    /**
     * 是否输出到本机文件
     */
    private static final boolean OUT_TO_PATH = false;
    /**
     * 是否根据参数查询
     */
    private static final boolean QUERY_BY_PARAMETER = false;
    /**
     * 要查询的参数
     */
    private static List<String> paramList = new ArrayList<>();

    private static final Watcher WATCHER = event -> {
    };
    private static ZooKeeper zooKeeper;

    static {
        try {
            zooKeeper = new ZooKeeper(CONNECTION_URL, SESSION_TIMEOUT, WATCHER);
        } catch (IOException e) {
            System.out.println("初始化ZooKeeper失败");
            e.printStackTrace();
            System.exit(1);
        }
        paramList.add("redis.pool.maxActive");
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();

        PrintStream oldOut = System.out;
        try {
            if (OUT_TO_PATH) {
                System.setOut(new PrintStream(new File(OUT_PATH)));
            }
            if (QUERY_BY_PARAMETER) {
                printPropertiesByParams(ROOT_PATH);
            } else {
                printAllProperties(ROOT_PATH);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            long l2 = System.currentTimeMillis();
            System.setOut(oldOut);
            System.out.println("总耗时-" + (l2 - l1));
        }


    }

    /**
     * 输出存在相应参数的配置文件信息
     *
     * @param path 要查询的目录
     */
    private static void printPropertiesByParams(String path) throws Exception {

        path = path.replaceAll("//+", "/");
        byte[] b = zooKeeper.getData(path, false, null);
        String s = new String(b);

        if (StringUtils.isNotBlank(s)) {
            Iterator<String> iterator = paramList.iterator();
            while (iterator.hasNext()) {
                String param = iterator.next();
                if (!s.contains(param)) {
                    continue;
                }
                JSONObject jsonObject = JSON.parseObject(s);
                System.out.println(path + "->" + param + "=" + jsonObject.get(param));
                if (!FULL_QUERY) {
                    iterator.remove();
                }
            }
        }

        if (paramList.size() == 0) {
            // 所有数据全部查询完毕
            throw new RuntimeException("");
        } else {
            List<String> list = zooKeeper.getChildren(path, false);
            for (String pathChild : list) {
                String child = path + "/" + pathChild;
                printPropertiesByParams(child);
            }
        }
    }

    /**
     * 输出配置文件信息
     *
     * @param path 要查询的目录
     */
    private static void printAllProperties(String path) throws Exception {

        path = path.replaceAll("//+", "/");
        byte[] b = zooKeeper.getData(path, false, null);
        String s = new String(b);

        List<String> list = zooKeeper.getChildren(path, false);
        if (list == null || list.size() == 0) {
            printPath(s, path);
        } else {
            for (String pathChild : list) {
                String child = path + "/" + pathChild;
                printAllProperties(child);
            }
        }
    }

    private static void printPath(String s, String path) {
        if (s.indexOf('[') == 0) {
            JSONArray parse = (JSONArray) JSON.parse(s);
            parse.forEach(o -> printPath(o.toString(), path));
            return;
        }
        if (s.indexOf('{') == 0) {
            JSONObject jsonObject = JSON.parseObject(s);
            if (jsonObject != null) {
                Set<String> strings = jsonObject.keySet();
                strings.forEach(str -> System.out.println(path + "->" + str + "=" + jsonObject.get(str)));
            }
            return;
        }
        System.out.println(path + "->" + s);
    }

}
