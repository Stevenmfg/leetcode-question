//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2623 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Problem_7_ReverseInteger().new Solution();
        System.out.println(solution.reverse(-1563847412));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int flag = x > 0 ? 1 : -1;
            x = Math.abs(x);
            long res = 0;

            while (x > 0) {
                int y = x % 10;
                res = res * 10 + y;
                x /= 10;
            }
            res *= flag;

            return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}