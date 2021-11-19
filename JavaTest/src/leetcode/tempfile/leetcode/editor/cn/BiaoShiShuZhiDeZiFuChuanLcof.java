package leetcode.tempfile.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-11-18 21:57:20
 *
 * @author BHT
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(BiaoShiShuZhiDeZiFuChuanLcof.class);
        System.out.println(solution.isNumber("1.38354e+8"));
        ;
    }
//}

// 第剑指 Offer 20题：表示数值的字符串
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
// 1 <= s.length <= 20
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 👍 261 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
enum Type {
    /**
     * 字符类型
     */
    BLANK,
    DIGIT,
    SIGN,
    DOT,
    E
}
class Solution {



    Type getType(char ch) {
        if (ch == ' ') {
            return Type.BLANK;
        }
        if (ch >= '0' && ch <= '9') {
            return Type.DIGIT;
        }
        if (ch == '-' || ch == '+') {
            return Type.SIGN;
        }
        if (ch == '.') {
            return Type.DOT;
        }
        if (ch == 'E' || ch == 'e') {
            return Type.E;
        }
        return null;
    }

    Map<Integer, Map<Type, Integer>> state = new HashMap<Integer, Map<Type, Integer>>() {{
        put(0, new HashMap<Type, Integer>() {{
            put(Type.BLANK, 0);
            put(Type.SIGN, 1);
            put(Type.DOT, 2);
            put(Type.DIGIT, 3);
        }});
        put(1, new HashMap<Type, Integer>() {{
            put(Type.DOT, 2);
            put(Type.DIGIT, 3);
        }});
        put(2, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 4);
        }});
        put(3, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 3);
            put(Type.E, 5);
            put(Type.DOT, 6);
            put(Type.BLANK, 9);
        }});
        put(4, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 4);
            put(Type.E, 5);
            put(Type.BLANK, 9);
        }});
        put(5, new HashMap<Type, Integer>() {{
            put(Type.SIGN, 7);
            put(Type.DIGIT, 8);
        }});
        put(6, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 4);
            put(Type.E, 5);
            put(Type.BLANK, 9);
        }});
        put(7, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 8);
        }});
        put(8, new HashMap<Type, Integer>() {{
            put(Type.DIGIT, 8);
            put(Type.BLANK, 9);
        }});
        put(9, new HashMap<Type, Integer>() {{
            put(Type.BLANK, 9);
        }});
    }};


    public boolean isNumber(String s) {

        char[] chars = s.toCharArray();

        int curr = 0;
        for (char ch : chars) {
            Type type = getType(ch);
            if (type == null) {
                return false;
            }
            Integer temp = state.get(curr).get(type);
            if (temp == null) {
                return false;
            }
            curr = temp;
        }

        return curr == 3 || curr == 4 || curr == 6 || curr == 8 || curr == 9;
    }

}
}

//leetcode submit region end(Prohibit modification and deletion)
  
