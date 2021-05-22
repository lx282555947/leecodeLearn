package com.learn.leecode.algorithm.maxSubArray;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(nums);
        System.out.println(maxSum);
    }
    /**
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     *
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //当前值的之前的和如果小于0则丢弃
        int preSum = -1;
        int curSum = -1;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //之前和大于等于0，则当前和相加，之前和也相加，
            //之前和小于0，则当前和重置为当前值
            if (preSum < 0) {
                curSum = num;
                preSum = curSum;
            } else {
                curSum += num;
                preSum += num;
            }
            //当前和和最大和进行比较
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
