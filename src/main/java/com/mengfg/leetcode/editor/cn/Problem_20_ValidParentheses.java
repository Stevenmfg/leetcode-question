//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2311 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.Stack;

class Problem_20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Problem_20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 1) {
                return false;
            }
            Stack<Character> stack = new Stack();
            while (!s.isEmpty() || !stack.isEmpty()) {
                if (!s.isEmpty() && (s.charAt(0) == '(' || s.charAt(0) == '[' || s.charAt(0) == '{')) {
                    stack.push(s.charAt(0));
                    s = s.substring(1);
                } else if (s.isEmpty() || stack.isEmpty()) {
                    return false;
                } else {
                    Character character = stack.pop();
                    switch (character) {
                        case '{':
                            if (s.charAt(0) != '}') {
                                return false;
                            }
                            s = s.substring(1);
                            break;
                        case '(':
                            if (s.charAt(0) != ')') {
                                return false;
                            }
                            s = s.substring(1);
                            break;
                        case '[':
                            if (s.charAt(0) != ']') {
                                return false;
                            }
                            s = s.substring(1);
                            break;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}