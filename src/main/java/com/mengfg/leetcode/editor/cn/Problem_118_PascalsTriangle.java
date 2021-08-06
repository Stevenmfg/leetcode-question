//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 536 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem_118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Problem_118_PascalsTriangle().new Solution();
        List<List<Integer>> generate = solution.generate(5);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                sb.append(integer).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
            sb = new StringBuilder();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Arrays.asList(1));
            if (numRows == 1) {
                return res;
            }
            res.add(Arrays.asList(1, 1));
            if (numRows == 2) {
                return res;
            }

            for (int i = 3; i < numRows + 1; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        list.add(1);
                    } else {
                        list.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                    }
                }
                res.add(list);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}