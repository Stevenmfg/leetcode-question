//给定两个字符串, A 和 B。 
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。 
//
// 
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false 
//
// 注意： 
//
// 
// A 和 B 长度不超过 100。 
// 
// 👍 121 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.Objects;

class Problem_796_RotateString {
    public static void main(String[] args) {
        Solution solution = new Problem_796_RotateString().new Solution();
        String A = "aa";
        String B = "a";
        System.out.println(solution.rotateString(A, B));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String A, String B) {
            if (Objects.isNull(A) && Objects.isNull(B)) {
                return true;
            }
            if (A.length() != B.length()) {
                return false;
            }
            if (A.length() == 0) {
                return true;
            }
            return kmp(A + A, B) > -1;
        }

        private int kmp(String a, String b) {
            int i = 0;
            int j = 0;
            int[] next = getNextArray(b);
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }

            return j == b.length() ? i - j : -1;
        }

        private int[] getNextArray(String b) {
            if (b.length() == 1) {
                return new int[]{-1};
            }

            int[] next = new int[b.length()];
            next[0] = -1;
            next[1] = 0;

            int i = 2;
            int cn = 0;
            while (i < b.length()) {
                if (b.charAt(i - 1) == b.charAt(cn)) {
                    next[i++] = ++cn;
                } else if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[i++] = 0;
                }
            }
            return next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

