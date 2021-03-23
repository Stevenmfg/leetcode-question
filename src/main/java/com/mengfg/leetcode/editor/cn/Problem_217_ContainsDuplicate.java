//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 376 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class Problem_217_ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Problem_217_ContainsDuplicate().new Solution();
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        solution.containsDuplicate(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap();
            for (int num : nums) {
                Integer target = map.get(num);
                if (target == null) {
                    map.put(num, 1);
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}