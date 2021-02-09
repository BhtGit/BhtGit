package leetcode.tempfile.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    /**
     * 2021-02-08 17:01:33
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(LongestPalindromicSubstring.class);
        String s = solution.longestPalindrome("ccc");
        System.out.println(s);
    }
}

// 第5题：最长回文子串
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
// 示例 2： 
//输入：s = "cbbd"
//输出："bb"
//
// 示例 3： 
//输入：s = "a"
//输出："a"
// 
// 示例 4：
//输入：s = "ac"
//输出："a"
//
// 提示： 
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3188 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        chars = manacherCharArray(chars);
        int longest = 0;
        int longestIndex = 0;

        /**
         * 2、怎么计算每一个位置为中心的最长回文串长度？
         *
         * 2.1、增加一个数据，和chars同等长度，用来记录每一个位置的回文串长度
         * 2.2、记录一个数据right，这个数据是截止到当前位置，所有最长回文串中触碰到的最靠右的位置  初始值为0
         *      记录一个数据lastIndex，这个数据是right对应的中心点的位置 初始值为0
         *      记录一个数组radiusArray，这个数组是每一个位置对应的回文半径长度-1 回文半径长度：121->2  1221->2
         */
        int right = 0;
        int lastIndex = 0;
        int[] radiusArray = new int[chars.length];
        /**
         * 2.3、开始计算
         * 2.3.1、如果当前位置超出了right，那么开始计算一个新的right和新的lastIndex
         * 2.3.2、如果当前位置在right内，取当前位置基于lastIndex对称位置的值
         * 2.3.2.1、如果对称位置的回文串范围超过了lastIndex的回文串范围，则当前节点为回文串右边界与right重合
         * 2.3.2.2、如果对称位置的回文串范围在lastIndex的回文串范围内（不重合），则当前节点的值和对称点的值相同
         * 2.3.2.3、如果对称位置的回文串范围和lastIndex刚好重合，则从right+1开始继续判断当前位置的最大长度，计算出结果后更改right的值
         *
         * 总结：总共有四种情况，其中两种情况可直接取值，两种情况right会右移
         */
        for (int i = 0; i < chars.length; i++) {
            // if的数量可以减少
            // 取消right计数，直接用radiusArray[i]计数代码量少一半，但是通过时间为30ms+,
            /*if (i > right) {
                radiusArray[i] = 1;
            } else {
                radiusArray[i] = Math.min(radiusArray[2 * lastIndex - i], right - i);
            }
            while (i - radiusArray[i] >= 0 && i + radiusArray[i] < chars.length && chars[i + radiusArray[i]] == chars[i - radiusArray[i]]) {
                radiusArray[i]++;
            }*/
            // 但是多加几个if未必是坏事  多加几个if执行时间为6ms
            // 应该是因为while里面的判断较多导致
            // todo 所以manacher算法首尾不能用同样的标识，会导致多判断几次，如果首尾符号不同，则可以不判断边界
            if (i > right) {
                right = Math.max(i, right);
                lastIndex = Math.max(i, lastIndex);
            }
            // 对称位置
            int symmetryIndex = 2 * lastIndex - i;
            if (i + radiusArray[symmetryIndex] != right) {
                radiusArray[i] = Math.min(radiusArray[symmetryIndex], right - i);
            } else {
                while (2 * i >= right && right < chars.length && chars[2 * i - right] == chars[right]) {
                    right++;
                }// 跳出循环时的right不满足条件，所以需要减1
                right--;
                radiusArray[i] = right - i;
                lastIndex = i;
            }

            if (radiusArray[i] > longest) {
                longest = radiusArray[i];
                longestIndex = i;
            }
        }

        int startIndex = longestIndex - longest;
        int endIndex = longestIndex + longest;
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            if (chars[i] != '\u0000') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /**
     * manacher 算法
     * 1、字符之间塞入一个统一的分隔符0   abc -> 0a0b0c0
     * 2、计算变更后的字符串每一个位置的值   以自我为中心的最长回文串长度
     * 3、返回最大值
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        chars = manacherCharArray(chars);
        int longest = 0;

        /**
         * 2、怎么计算每一个位置为中心的最长回文串长度？
         *
         * 2.1、增加一个数据，和chars同等长度，用来记录每一个位置的回文串长度
         * 2.2、记录一个数据right，这个数据是截止到当前位置，所有最长回文串中触碰到的最靠右的位置  初始值为0
         *      记录一个数据lastIndex，这个数据是right对应的中心点的位置 初始值为0
         *      记录一个数组radiusArray，这个数组是每一个位置对应的回文半径长度-1 回文半径长度：121->2  1221->2
         */
        int right = 0;
        int lastIndex = 0;
        int[] radiusArray = new int[chars.length];
        /**
         * 2.3、开始计算
         * 2.3.1、如果当前位置超出了right，那么开始计算一个新的right和新的lastIndex
         * 2.3.2、如果当前位置在right内，取当前位置基于lastIndex对称位置的值
         * 2.3.2.1、如果对称位置的回文串范围超过了lastIndex的回文串范围，则当前节点为回文串右边界与right重合
         * 2.3.2.2、如果对称位置的回文串范围在lastIndex的回文串范围内（不重合），则当前节点的值和对称点的值相同
         * 2.3.2.3、如果对称位置的回文串范围和lastIndex刚好重合，则从right+1开始继续判断当前位置的最大长度，计算出结果后更改right的值
         *
         * 总结：总共有四种情况，其中两种情况可直接取值，两种情况right会右移
         */
        for (int i = 0; i < chars.length; i++) {
            if (i > right) {
                right = i;
                while (2 * i >= right && right < chars.length && chars[2 * i - right] == chars[right]) {
                    right++;
                }
                // 跳出循环时的right不满足条件，所以需要减1
                right--;
                radiusArray[i] = right - i;
                lastIndex = i;
            } else {
                // 对称位置
                int symmetryIndex = 2 * lastIndex - i;
                if (i + radiusArray[symmetryIndex] != right) {
                    radiusArray[i] = Math.min(radiusArray[symmetryIndex], right - i);
                } else {
                    while (2 * i >= right && right < chars.length && chars[2 * i - right] == chars[right]) {
                        right++;
                    }// 跳出循环时的right不满足条件，所以需要减1
                    right--;
                    radiusArray[i] = right - i;
                    lastIndex = i;
                }
            }

            longest = Math.max(radiusArray[i], longest);
        }

        return longest;
    }

    /**
     * 字符数组中间插入空格
     */
    private char[] manacherCharArray(char[] chars) {
        char[] result = new char[2 * chars.length + 1];
        for (int i = 0; i < chars.length; i++) {
            result[2 * i + 1] = chars[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
