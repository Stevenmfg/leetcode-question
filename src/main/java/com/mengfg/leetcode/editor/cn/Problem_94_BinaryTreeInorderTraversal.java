//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 895 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem_94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Problem_94_BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println((solution.inorderTraversal(root)));
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        public void process1(TreeNode treeNode, List<Integer> list) {
            if (treeNode == null) {
                return;
            }

            process1(treeNode.left, list);
            list.add(treeNode.val);
            process1(treeNode.right, list);
        }

        /**
         * 迭代
         *
         * @param root
         * @param list
         */
        void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }

        /**
         * TODO: morris序
         *
         * @param treeNode
         * @param list
         */
        public void morris(TreeNode treeNode, List<Integer> list) {
            TreeNode mostRight;
            TreeNode cur = treeNode;

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
                        // 说明mostRight.right == cur;
                        mostRight.right = null;
                    }
                }
                list.add(cur.val);
                cur = cur.right;
            }
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