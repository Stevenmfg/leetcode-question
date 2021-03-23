//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 293 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_231_PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Problem_231_PowerOfTwo().new Solution();
        for (int i = 0; i < 1024; i++) {
            boolean powerOfTwo = solution.isPowerOfTwo2(i);
            if (powerOfTwo) {
                System.out.println(i);
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }

            return (n | n - 1) == ((n << 1) -1);
        }

        public boolean isPowerOfTwo2(int n) {
            if (n <= 0) {
                return false;
            }
            String s = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, 1));
            for (int i = 0; i < s.length() - 1; i++) {
                sb.append("0");
            }
            int i = Integer.parseInt(sb.toString(), 2);
            return (n ^ i) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}