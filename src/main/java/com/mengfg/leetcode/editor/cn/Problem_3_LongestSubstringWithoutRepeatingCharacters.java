//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6027 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class Problem_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Problem_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("asdegeba"));
        System.out.println(solution.lengthOfLongestSubstring2("asdegeba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 快慢指针
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if (length == 0 || length == 1) {
                return length;
            }

            int res = 0;
            int rk = -1;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }

                while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    set.add(s.charAt(rk + 1));
                    ++rk;
                }

                res = Math.max(res, rk - i + 1);
            }

            return res;
        }

        /**
         * 动态规划，是不可以的，因为没法儿判断是否含有重复字符
         *
         * @param s
         * @return
         */
        @Deprecated
        public int lengthOfLongestSubstring2(String s) {
            int length = s.length();
            if (length == 0 || length == 1) {
                return length;
            }
            // dp[i]表示以s.charAt(i)结尾的最长子串是多少
            int[] dp = new int[s.length()];
            dp[0] = 1;
            int res = 0;
            for (int i = 1; i < s.length(); i++) {
                dp[i] = s.charAt(i - dp[i - 1]) == s.charAt(i) ? 1 : dp[i - 1] + 1;
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}