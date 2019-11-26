package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：BHT
 * @date ：2019-07-28 15:26
 */
public class Test05 {

    public static void main(String[] args) {
        String[] s=new String[]{"CAT","TIGER","RPC"};
//      String[] s = {"gwj","jcl","dlg","akd","qag"};
        System.out.println(isLink(s));
    }

    private static boolean isLink(String[] s) {
        StringBuilder sb=new StringBuilder();
        for(String str:s){
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length()-1));
        }
        List<String> list=listAll(Arrays.asList(sb.toString().split("")),"");
        for(String str:list){
            if(check(str)){
                return true;
            }
        }
        return false;
    }

    private static boolean check(String str) {
        for(int i=1;i<=str.length()-3;i=i+2){
            if(str.charAt(i)!=str.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    private static List<String> listAll(List<String> candidate, String prefix) {
        List<String> list=new ArrayList<String>();
        if(candidate.isEmpty()) {
            list.add(prefix);
        }else {
            for (int i = 0; i < candidate.size(); i++) {
                List temp = new LinkedList(candidate);//为了方便提取后删除每个元素
                List<String> results=listAll(temp, prefix + temp.remove(i));
                for(String s:results){
                    list.add(s);
                }
            }
        }
        return list;
    }


}
