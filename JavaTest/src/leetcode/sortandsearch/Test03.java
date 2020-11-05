package leetcode.sortandsearch;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author BHT 2020/10/30 15:23
 */
public class Test03 {

    public static void main(String[] args) {

        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int k = 2;
        int kthLargest = new Test03().findKthLargest(nums, k);
        System.out.println(kthLargest);

    }

    public int findKthLargest(int[] nums, int k) {
        // 使用快排取值
        return findKthLargest(nums, k, 0, nums.length - 1, nums[0]);
    }

    /**
     * 利用快排查找第K大的数字
     *
     * @param nums         查找的数组
     * @param k            第k大
     * @param start        查找起始坐标
     * @param end          查找结束坐标
     * @param referenceNum 参照值
     * @return 第K大的数字
     */
    private int findKthLargest(int[] nums, int k, int start, int end, int referenceNum) {

        int tempStart = start;
        int tempEnd = end;
        // 从左边开始查找为true
        boolean findLeft = false;
        while (start < end) {
            if (findLeft) {
                if (nums[start] < referenceNum) {
                    nums[end] = nums[start];
                    end--;
                    findLeft = false;
                } else {
                    start++;
                }
            } else {
                if (nums[end] >= referenceNum) {
                    nums[start] = nums[end];
                    start++;
                    findLeft = true;
                } else {
                    end--;
                }
            }
        }
        // 循环结束时  start==end 仅留下referenceNum没安置
        // 快排一次完毕后，判断初始值的当前位置是否正好为第k个
        if (start + 1 < k) {
            return findKthLargest(nums, k, start + 1, tempEnd, nums[start + 1]);
        }
        if (start + 1 > k) {
            return findKthLargest(nums, k, tempStart, start - 1, nums[tempStart]);
        }
        return referenceNum;
    }


    public int findKthLargest2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        TreeNode node = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            node.addNode(nums[i]);
        }

        return node.getTopKValue(k);

    }

    /**
     * 左子树>右子树的二叉搜索树
     */
    public class TreeNode {
        private TreeNode parentNode;
        private TreeNode leftNode;
        private TreeNode rightNode;
        private int value;
        // 以当前节点为根节点，统计二叉树节点个数
        private int length = 1;
        private int leftLength = 0;
        private int rightLength = 0;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getLength() {
            return length;
        }

        /**
         * 增加子节点
         *
         * @param value 子节点的值
         */
        public void addNode(int value) {
            length++;
            if (this.value <= value) {
                leftLength++;
                if (this.leftNode == null) {
                    this.leftNode = new TreeNode(value);
                    this.leftNode.parentNode = this;
                } else {
                    this.leftNode.addNode(value);
                }
            } else {
                rightLength++;
                if (this.rightNode == null) {
                    this.rightNode = new TreeNode(value);
                    this.rightNode.parentNode = this;
                } else {
                    this.rightNode.addNode(value);
                }
            }
        }

        /**
         * 获取第k大的值
         *
         * @param k
         * @return
         */
        public int getTopKValue(int k) {
            if (k == this.leftLength + 1) {
                return this.value;
            }
            if (k > this.leftLength + 1) {
                return this.rightNode.getTopKValue(k - this.leftLength - 1);
            }
            if (k < this.leftLength + 1) {
                return this.leftNode.getTopKValue(k);
            }
            return 0;
        }


    }


}
