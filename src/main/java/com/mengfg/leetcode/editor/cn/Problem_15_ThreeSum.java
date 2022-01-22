//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3901 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Problem_15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Problem_15_ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        lists.stream().forEach(list -> System.out.println(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0) {
                return Collections.emptyList();
            }

            Arrays.sort(nums);

            List res = new LinkedList();
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    int[] ints = twoSum(nums, i + 1, -nums[i]);
                    if (ints != null) {
                        res.add(Arrays.asList(nums[i], nums[ints[0]], nums[ints[1]]));
                    }
                } else if (nums[i] != nums[i - 1]) {
                    int[] ints = twoSum(nums, i + 1, -nums[i]);
                    if (ints != null) {
                        res.add(Arrays.asList(nums[i], nums[ints[0]], nums[ints[1]]));
                    }
                }
            }
            return res;
        }

        public int[] twoSum(int[] nums, int index, int target) {
            int leftIndex = index;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] == target) {
                    return new int[]{leftIndex, rightIndex};
                } else if (nums[leftIndex] + nums[rightIndex] > target) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}