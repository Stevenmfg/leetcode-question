//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4368 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Problem_5_LongestPalindromicSubstring().new Solution();
        String s = "aaaa";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            if (s.length() == 2) {
                return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
            }

            int start = 0;
            int maxLen = 1;
            boolean[][] dp = new boolean[s.length()][s.length()];
            // dp[i][j] 表示从i到j的字符串是否为回文串，初始化单个字符的dp数组为true
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i + 1 < 3) {
                            dp[i][j] = true;
                        } else if (i + 1 < s.length() && dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                        if (dp[i][j] && j - i + 1 > maxLen) {
                            start = i;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}