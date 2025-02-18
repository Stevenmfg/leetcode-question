//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 479 👎 0


package com.mengfg.leetcode.editor.cn;


class Problem_111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Problem_111_MinimumDepthOfBinaryTree().new Solution();
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(5);
        head.right = new TreeNode(4);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(head));
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
        public int minDepth(TreeNode root) {
            return dfs(root);
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right != null) {
                return dfs(root.right) + 1;
            } else if (root.left != null && root.right == null) {
                return dfs(root.left) + 1;
            }

            return Math.min(dfs(root.left), dfs(root.right)) + 1;
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
//leetcode submit region end(Prohibit modification and deletion)

}