//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 613 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem_144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Problem_144_BinaryTreePreorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> integers = solution.preorderTraversal(root);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : integers) {
            sb.append(integer).append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                if (root != null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop().right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

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
}