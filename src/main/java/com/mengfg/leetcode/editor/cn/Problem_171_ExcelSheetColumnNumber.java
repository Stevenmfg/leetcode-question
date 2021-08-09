//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 
// 👍 282 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new Problem_171_ExcelSheetColumnNumber().new Solution();
        System.out.println(solution.titleToNumber("FXSHRXW"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int length = 'Z' - 'A' + 1;
            int base = 1;
            int res = 0;
            while (columnTitle != null && !columnTitle.isEmpty()) {
                char c = columnTitle.charAt(columnTitle.length() - 1);
                res = (c - 'A' + 1) * base + res;
                base = base * length;
                columnTitle = columnTitle.substring(0, columnTitle.length() - 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}