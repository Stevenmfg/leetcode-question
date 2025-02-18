//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 649 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_66_PlusOne {
    public static void main(String[] args) {
        Solution solution = new Problem_66_PlusOne().new Solution();
        int[] digits = {9, 9, 9};
        int[] res = solution.plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int len = digits.length;

            for (int i = 0; i < len; i++) {
                int x = (digits[len - 1 - i] + carry);
                if (i == 0) {
                    ++x;
                }

                digits[len - 1 - i] = x % 10;
                carry = x / 10;

                if (carry == 0) {
                    break;
                }
            }
            if (carry > 0) {
                int[] res = new int[digits.length + 1];
                System.arraycopy(digits, 0, res, 1, len);
                res[0] = carry;
                return res;
            }
            return digits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}