//给你一个字符串 s，由若干单词组成，单词之间用单个或多个连续的空格字符隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 336 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_58_LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Problem_58_LengthOfLastWord().new Solution();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWord(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int last = s.length() - 1;
            while (last >= 0 && s.charAt(last) == ' ') {
                last--;
            }

            int index = last;
            while (index >= 0 && s.charAt(index) != ' ') {
                index--;
            }
            return last - index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}