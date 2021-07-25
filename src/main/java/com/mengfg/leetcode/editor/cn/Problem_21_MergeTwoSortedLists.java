//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1646 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Problem_21_MergeTwoSortedLists().new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        System.out.println(solution.mergeTwoLists(l1, l2));
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }

            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            int small;
            if (l1.val <= l2.val) {
                small = l1.val;
                l1 = l1.next;
            } else {
                small = l2.val;
                l2 = l2.next;
            }

            ListNode list = new ListNode(small);
            list.next = mergeTwoLists(l1, l2);
            return list;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}