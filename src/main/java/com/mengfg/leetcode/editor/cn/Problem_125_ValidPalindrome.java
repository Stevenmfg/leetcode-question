//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal  Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 351 👎 0


package com.mengfg.leetcode.editor.cn;


class Problem_125_ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Problem_125_ValidPalindrome().new Solution();
        String str = ".,";
        System.out.println(solution.isPalindrome(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int len = s.length();
            int i = 0;
            int j = len - 1;
            while (i < j) {

                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }

                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }

                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}