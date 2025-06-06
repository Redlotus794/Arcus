package com.rdlts.leetcode.solution;

public class _209MinimumSizeSubarraySum {

//    public static int minSubArrayLen(int target, int[] nums) {
//        // 当前最小长度，如果到1 则直接返回
//        int minLength = Integer.MAX_VALUE;
//
//        // 从最左边开始滑动窗口计算
//        for (int left = 0; left < nums.length; left++) {
//            int currentSum = nums[left];
//
//            if (currentSum >= target) {
//                // 如果当前数值大于target，则返回1;
//                return 1;
//            }
//
//            for (int right = left + 1; right < nums.length; right++) {
//                if (right - left + 1 >= minLength) {
//                    // 窗口长度等于最小长度则跳出该次循环。
//                    break;
//                }
//
//                currentSum += nums[right];
//                if (currentSum >= target) {
//                    minLength = right - left + 1;
//                    break;
//                }
//            }
//        }
//
//        return minLength == Integer.MAX_VALUE ? 0 : minLength;
//    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        System.out.println("The minimum length of a contiguous subarray with sum at least " + target + " is: " + result);
    }
}
