//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 312 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem_119_PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new Problem_119_PascalsTriangleIi().new Solution();
        List<Integer> generate = solution.getRow(5);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : generate) {
            sb.append(integer).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            rowIndex++;
            if (rowIndex == 1) {
                return Arrays.asList(1);
            }
            if (rowIndex == 2) {
                return Arrays.asList(1, 1);
            }

            List<List<Integer>> lists = new ArrayList<>(rowIndex);
            lists.add(Arrays.asList(1));
            lists.add(Arrays.asList(1, 1));
            for (int i = 3; i < rowIndex + 1; i++) {
                List<Integer> subList = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        subList.add(1);
                    } else {
                        subList.add(lists.get(i - 2).get(j - 1) + lists.get(i - 2).get(j));
                    }
                }
                lists.add(subList);
            }

            return lists.get(rowIndex - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}