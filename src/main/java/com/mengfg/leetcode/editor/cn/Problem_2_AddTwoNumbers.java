//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7384 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Problem_2_AddTwoNumbers().new Solution();
        // 9,9,9,9,9,9,9
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(sb);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dump = new ListNode();
            ListNode node = dump;
            int pre = 0;
            while (l1 != null && l2 != null) {
                int val = l1.val + l2.val + pre;
                node.next = new ListNode(val % 10);
                pre = val / 10;
                l1 = l1.next;
                l2 = l2.next;
                node = node.next;
            }
            while (l1 != null) {
                int val = l1.val + pre;
                node.next = new ListNode(val % 10);
                pre = val / 10;
                l1 = l1.next;
                node = node.next;
            }
            while (l2 != null) {
                int val = l2.val + pre;
                node.next = new ListNode(val % 10);
                pre = val / 10;
                l2 = l2.next;
                node = node.next;
            }
            if (pre != 0) {
                node.next = new ListNode(pre);
            }
            return dump.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}