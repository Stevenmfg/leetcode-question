//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。 
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 蓄水池抽样 
// 👍 97 👎 0


package com.mengfg.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Problem_398_RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Problem_398_RandomPickIndex().new Solution(nums);
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        for (int i = 0; i < 1000; i++) {
            int pick = solution.pick(3);
            Integer j = map.get(pick);
            j++;
            map.put(pick, j);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(map.get(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] nums;
        Random r = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int i = 0;
            int j = 1;
            int res = 0;
            while (i < nums.length) {
                if (nums[i] == target) {
                    int random = r.nextInt(j);
                    if (random == 0) {
                        res = i;
                    }
                    j++;
                }
                i++;
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}