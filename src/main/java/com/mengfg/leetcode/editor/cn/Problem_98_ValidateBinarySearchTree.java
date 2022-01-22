//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 980 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Problem_98_ValidateBinarySearchTree().new Solution();
        TreeNode head = new TreeNode(2147483647);
        // head.left = new TreeNode(1);
        // head.right = new TreeNode(4);
        // head.right.left = new TreeNode(3);
        // head.right.right = new TreeNode(6);
        System.out.println(solution.isValidBST(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return process(root).isBST;
        }

        public NodeInfo process(TreeNode node) {
            if (node == null) {
                return new NodeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            NodeInfo left = process(node.left);
            NodeInfo right = process(node.right);

            boolean isBST = left.isBST && right.isBST && node.val >= left.max && node.val <= right.min;
            int max = Math.max(node.val, right.max);
            int min = Math.min(node.val, left.min);
            return new NodeInfo(isBST, max, min);
        }

        public boolean morris(TreeNode node) {
            TreeNode prev = null;
            TreeNode mostRight;
            TreeNode cur = node;
            while (cur != null) {
                mostRight = cur.left;
                if (mostRight != null) {
                    while (mostRight.right != null && mostRight.right != cur) {
                        mostRight = mostRight.right;
                    }
                    if (mostRight.right == null) {
                        mostRight.right = cur;
                        cur = cur.left;
                        continue;
                    } else {
                        mostRight.right = null;
                    }
                }
                if (prev != null && cur.val <= prev.val) {
                    return false;
                }
                prev = cur;
                cur = cur.right;
            }
            return true;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class NodeInfo {
        boolean isBST;
        int max;
        int min;

        public NodeInfo() {
        }

        public NodeInfo(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}