package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * .     1   abc  def
 * .    ghi  jkl  mno
 * .    pqrs tuv  wxyz
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author ：BHT
 * @date ：2019-08-07 09:50
 */
public class Test01 {

    public static List<String[]> phoneKeyboard = new ArrayList<>();

    static {
        String[] nullArray = {};
        phoneKeyboard.add(nullArray);
        phoneKeyboard.add(nullArray);
        phoneKeyboard.add(new String[]{"a", "b", "c"});
        phoneKeyboard.add(new String[]{"d", "e", "f"});
        phoneKeyboard.add(new String[]{"g", "h", "i"});
        phoneKeyboard.add(new String[]{"j", "k", "l"});
        phoneKeyboard.add(new String[]{"m", "n", "o"});
        phoneKeyboard.add(new String[]{"p", "q", "r", "s"});
        phoneKeyboard.add(new String[]{"t", "u", "v"});
        phoneKeyboard.add(new String[]{"w", "x", "y", "z"});
    }


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0 || digits.replaceAll(" +", "").length() == 0) {
            return list;
        }

        for (char ch : digits.toCharArray()) {
            int index = Integer.parseInt(Character.toString(ch));
            String[] strs = phoneKeyboard.get(index);
            List<String> newList = new ArrayList<>();
            for (String s2 : strs) {
                if (list.size() == 0) {
                    newList.add(s2);
                } else {
                    for (String s1 : list) {
                        newList.add(s1 + s2);
                    }
                }
            }
            list = newList;
        }

        return list;
    }

    public static void main(String[] args) {
        Test01 t = new Test01();

        List<String> strings = t.letterCombinations("23");
        System.out.println(strings);

    }

}
