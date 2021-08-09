//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1086 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.Map;
import java.util.TreeMap;

class Problem_169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Problem_169_MajorityElement().new Solution();
        int[] nums = new int[]{3, 2, 3};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            Map<Integer, Integer> map = new TreeMap();
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) != null) {
                    if (map.get(nums[i]) + 1 > nums.length / 2) {
                        res = nums[i];
                        break;
                    }
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}