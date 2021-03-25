//给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。 
//
// 进阶: 
//如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？ 
//
// 示例: 
//
// 
//// 初始化一个单链表 [1,2,3].
//ListNode head = new ListNode(1);
//head.next = new ListNode(2);
//head.next.next = new ListNode(3);
//Solution solution = new Solution(head);
//
//// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//solution.getRandom();
// 
// Related Topics 蓄水池抽样 
// 👍 124 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

class Problem_382_LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Problem_382_LinkedListRandomNode().new Solution(head);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        // System.out.println(solution.getRandom());
        for (int i = 0; i < 1000; i++) {
            int random = solution.getRandom();
            Integer integer = map.get(random);
            map.put(random, ++integer);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(map.get(i));
        }

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
        private ListNode head;
        Random r = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int i = 1;
            int res = 0;
            ListNode h = head;
            while (Objects.nonNull(h)) {
                int random = r.nextInt(i);
                if (random == 0) {
                    res = h.val;
                }
                h = h.next;
                i++;
            }
            return res;
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

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}