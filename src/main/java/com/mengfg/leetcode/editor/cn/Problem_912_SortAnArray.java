package com.mengfg.leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 239 👎 0


class Problem_912_SortAnArray {
    public static void main(String[] args) {
        Solution solution = new Problem_912_SortAnArray().new Solution();
        int[] nums = {1, 3, 5, 8, 2, 0, 0};
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println(",");
        solution.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println(",");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            // 从小到大排序
            qickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void qickSort(int[] nums, int L, int R) {
            if(L >= R) {
                return;
            }
            int[] result = partition(nums, L, R);
            qickSort(nums, L, result[0] - 1);
            qickSort(nums, result[1] + 1, R);
        }

        private int[] partition(int[] arr, int L, int R) {
            if (L > R) {
                return new int[]{-1, -1};
            }
            if (L == R) {
                return new int[]{L, R};
            }

            int less = L - 1;
            int index = L;
            int more = R;
            while (index < more) {
                if (arr[index] == arr[R]) {
                    index++;
                } else if (arr[index] < arr[R]) {
                    swap(arr, ++less, index++);
                } else {
                    swap(arr, index, --more);
                }
            }
            swap(arr, R, more);

            return new int[]{less + 1, more};
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}