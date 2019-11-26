package leetcode.arrayandstring;

import java.util.*;

/**
 * 字谜分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Test03 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, Integer> tempMap = new HashMap<>();
        int index = 0;
        for (String str : strs) {
            String sortStr = sortStr(str);
            Integer integer = tempMap.get(sortStr);
            if (integer!=null) {
                List<String> list = lists.get(integer);
                list.add(str);
            } else {
                tempMap.put(sortStr,index);
                index++;
                List<String> list = new ArrayList<>();
                list.add(str);
                lists.add(list);
            }
        }
        return lists;
    }

    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] s = {"", ""};
        List<List<String>> lists = new Test03().groupAnagrams(s);
        System.out.println(lists);
    }

}
