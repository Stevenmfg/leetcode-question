//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1764 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Problem_19_RemoveNthNodeFromEndOfList().new Solution();
        ListNode listNode = new ListNode(1);
        // listNode.next = new ListNode(2);
        // listNode.next.next = new ListNode(3);
        // listNode.next.next.next = new ListNode(4);
        ListNode res = solution.removeNthFromEnd(listNode, 1);
        StringBuilder sb = new StringBuilder();
        while (res != null) {
            sb.append(res.val).append(",");
            res = res.next;
        }
        System.out.println(sb.toString());
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = reverseList(head);
            newHead = removeNthFromStart(newHead, n);
            return newHead == null ? null : reverseList(newHead);
        }

        private ListNode removeNthFromStart(ListNode newHead, int n) {
            ListNode head;
            if (n == 1) {
                head = newHead.next;
                return head;
            } else {
                head = newHead;
            }

            while (n - 1 > 1) {
                newHead = newHead.next;
                n--;
            }

            newHead.next = newHead.next.next;
            return head;
        }

        /**
         * 列表反转，并返回新的头节点
         *
         * @param head
         * @return
         */
        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head.next != null) {
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
            }
            head.next = prev;
            return head;
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