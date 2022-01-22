//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 441 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class Problem_242_ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Problem_242_ValidAnagram().new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> map = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    map.put(s.charAt(i), 1);
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                Integer integer = map.get(t.charAt(i));
                if (integer == null || integer - 1 < 0) {
                    return false;
                } else {
                    map.put(t.charAt(i), --integer);
                }
            }

            return !map.entrySet().stream().anyMatch(entry -> entry.getValue() != 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}