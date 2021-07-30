//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1032 👎 0


package com.mengfg.leetcode.editor.cn;


class Problem_88_MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new Problem_88_MergeSortedArray().new Solution();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3, n = 3;
        solution.merge(nums1, m, nums2, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums1.length; i++) {
            sb.append(nums1[i]).append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n <= 0) {
                return;
            }
            for (int i = m + n - 1; i >= 0; i--) {
                if (n - 1 >= 0 && m - 1 >= 0) {
                    if (nums2[n - 1] > nums1[m - 1]) {
                        nums1[i] = nums2[n - 1];
                        n--;
                    } else {
                        nums1[i] = nums1[m - 1];
                        m--;
                    }
                } else if (m - 1 < 0) {
                    nums1[i] = nums2[n - 1];
                    n--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}