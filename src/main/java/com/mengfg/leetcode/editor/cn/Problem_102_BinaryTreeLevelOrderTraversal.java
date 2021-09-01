//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 981 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem_102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Problem_102_BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);

        List<List<Integer>> lists = solution.levelOrder(root);
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : list) {
                sb.append(integer).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new LinkedList();
            if (root == null) {
                return list;
            }

            Queue<NodeInfo> queue = new LinkedList();
            queue.offer(new NodeInfo(root, 0));

            while (!queue.isEmpty()) {
                NodeInfo nodeInfo = queue.poll();
                int level = nodeInfo.level;
                if (nodeInfo.node.left != null) {
                    queue.offer(new NodeInfo(nodeInfo.node.left, level + 1));
                }
                if (nodeInfo.node.right != null) {
                    queue.offer(new NodeInfo(nodeInfo.node.right, level + 1));
                }
                List<Integer> subList = new LinkedList<>();
                subList.add(nodeInfo.node.val);
                while (!queue.isEmpty() && queue.peek().level == level) {
                    NodeInfo poll = queue.poll();
                    subList.add(poll.node.val);
                    if (poll.node.left != null) {
                        queue.offer(new NodeInfo(poll.node.left, level + 1));
                    }
                    if (poll.node.right != null) {
                        queue.offer(new NodeInfo(poll.node.right, level + 1));
                    }
                }
                list.add(subList);
            }
            return list;
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

    }

    public class NodeInfo {
        TreeNode node;
        int level;

        public NodeInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}