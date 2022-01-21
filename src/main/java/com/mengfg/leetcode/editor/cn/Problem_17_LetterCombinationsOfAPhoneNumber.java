//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1685 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem_17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Problem_17_LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("2");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return Collections.emptyList();
            }
            Map<Character, List<String>> map = new HashMap<>();
            map.put('2', Arrays.asList("a", "b", "c"));
            map.put('3', Arrays.asList("d", "e", "f"));
            map.put('4', Arrays.asList("g", "h", "i"));
            map.put('5', Arrays.asList("j", "k", "l"));
            map.put('6', Arrays.asList("m", "n", "o"));
            map.put('7', Arrays.asList("p", "q", "r", "s"));
            map.put('8', Arrays.asList("t", "u", "v"));
            map.put('9', Arrays.asList("w", "x", "y", "z"));


            List<String> result = new ArrayList<>();
            recursive(digits, 0, new StringBuilder(), map, result);
            return result;
        }


        public void recursive(String digits, int index, StringBuilder tmp, Map<Character, List<String>> map, List<String> res) {
            if (digits.length() == index) {
                res.add(tmp.toString());
                return;
            } else {
                List<String> strings = map.get(digits.charAt(index));
                for (String string : strings) {
                    tmp.append(string);
                    recursive(digits, index + 1, tmp, map, res);
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}