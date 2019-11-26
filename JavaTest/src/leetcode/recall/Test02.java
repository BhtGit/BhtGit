package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author ：BHT
 * @date ：2019-08-07 10:46
 */
public class Test02 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        buildList(list, new char[2 * n], 0, n, n, true);
        return list;
    }

    private void buildList(List<String> list, char[] chars, int index, int bracketOpen, int bracketClose, boolean left) {
        if (left && bracketOpen > 0) {
            chars[index] = '(';
            index++;
            bracketOpen--;
        } else if (!left && bracketOpen < bracketClose) {
            chars[index] = ')';
            index++;
            bracketClose--;
        } else {
            return;
        }
        if (index == chars.length) {
            String s = new String(chars);
            list.add(s);
            return;
        }
        buildList(list, chars, index, bracketOpen, bracketClose, true);
        buildList(list, chars, index, bracketOpen, bracketClose, false);
    }

    public static void main(String[] args) {
        Test02 t = new Test02();

        int n = 16;
        List<String> list = t.generateParenthesis(n);
//        list.forEach(System.out::println);
        System.out.println(list.size());
    }

}
