package leetcode.tempfile.leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    /**
     * 2021-11-13 23:07:14
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ErChaSouSuoShuDeHouXuBianLiXuLieLcof.class);
//        System.out.println(solution.verifyPostorder(new int[]{1,6,3,2,5}));
//        System.out.println(solution.verifyPostorder(new int[]{1,3,2,6,5}));
//        System.out.println(solution.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
        System.out.println(solution.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }
//}

// 第剑指 Offer 33题：二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 376 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 辅助单调栈
    /*public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }*/

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (end <= start) {
            return true;
        }

        int leftStart = start;
        int leftEnd = end - 1;
        int rightStart = end - 1;
        int rightEnd = end - 1;
        // 从左往右查找，碰到第一个比root大的，就是左右子树的分界线
        for (; start < end - 1; start++) {
            if (postorder[start] < postorder[end]) {
                continue;
            }
            leftEnd = start - 1;
            rightStart = start;
            // 右边的必须全部比他大
            while (start <= end && postorder[start] > postorder[end]) {
                start++;
            }
            if (start != end) {
                return false;
            }
            break;
        }
        return verifyPostorder(postorder, leftStart, leftEnd)
                && verifyPostorder(postorder, rightStart, rightEnd);

    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
