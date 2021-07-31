//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1304 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class Problem_101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Problem_101_SymmetricTree().new Solution();
        // [1,2,2,null,3,null,3]
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(head));
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isEqual2(root, root);
        }

        /**
         * 递归
         *
         * @param node1
         * @param node2
         * @return
         */
        public boolean isEqual(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            return node1.val == node2.val && isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left);
        }

        public boolean isEqual2(TreeNode node1, TreeNode node2) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node1);
            queue.offer(node2);

            while (!queue.isEmpty()) {
                TreeNode x = queue.poll();
                TreeNode y = queue.poll();
                if (x == null && y == null) {
                    continue;
                }
                if (x == null || y == null || x.val != y.val) {
                    return false;
                }

                queue.offer(x.right);
                queue.offer(y.left);

                queue.offer(x.left);
                queue.offer(y.right);
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

//leetcode submit region end(Prohibit modification and deletion)

}