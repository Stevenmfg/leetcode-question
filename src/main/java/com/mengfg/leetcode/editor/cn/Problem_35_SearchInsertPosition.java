//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 978 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_35_SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Problem_35_SearchInsertPosition().new Solution();
        int[] nums = {1};
        System.out.println(solution.searchInsert(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return binarySearch(target, 0, nums.length - 1, nums);
        }

        public int binarySearch(int target, int start, int end, int[] nums) {
            if (start == end) {
                return nums[start] < target ? ++start : start;
            }

            int middle = (start + end) / 2;
            if (middle == start) {
                return nums[start] < target ? (nums[end] < target ? ++end : end) : start;
            }

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
            return binarySearch(target, start, end, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}