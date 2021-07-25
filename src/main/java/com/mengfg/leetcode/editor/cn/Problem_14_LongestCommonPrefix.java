//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1532 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Problem_14_LongestCommonPrefix().new Solution();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            String str0 = strs[0];
            for (int i = 0; i < strs[0].length(); i++) {
                for (int k = 0; k < strs.length - 1; k++) {
                    String before = strs[k];
                    String after = strs[k + 1];
                    if (before.length() <= i || after.length() <= i) {
                        return before.length() < after.length() ? before : after;
                    }
                    if (before.charAt(i) != after.charAt(i)) {
                        return before.substring(0, i);
                    }
                }
            }
            return str0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}