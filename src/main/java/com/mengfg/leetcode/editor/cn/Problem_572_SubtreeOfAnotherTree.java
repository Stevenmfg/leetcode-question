//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 528 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.Stack;

class Problem_572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new Problem_572_SubtreeOfAnotherTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        boolean subtree = solution.isSubtree(root, root.left);
        System.out.println(subtree);
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return preOrder(root, subRoot);
        }

        public boolean preOrder(TreeNode root, TreeNode subRoot) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
            return false;
        }

        public boolean inOrder(TreeNode root, TreeNode subRoot) {
            Stack<TreeNode> stack = new Stack();
            TreeNode curr = root;
            while (curr != null || !stack.empty()) {
                if (curr != null) {
                    curr = stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (isSameTree(curr, subRoot)) {
                        return true;
                    }
                    curr = curr.right;
                }
            }
            return false;
        }

        public boolean isSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            } else if (t1 == null && t2 != null) {
                return false;
            } else if (t1 != null && t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
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