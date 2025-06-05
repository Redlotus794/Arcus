package com.rdlts.leetcode.solution;

/**
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2


 Constraints:

 n == nums.length
 1 <= n <= 5 * 104
 -109 <= nums[i] <= 109
 */
public class _169MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        _169MajorityElement solution = new _169MajorityElement();
        int[] nums = {3, 2, 3};
        int result = solution.majorityElement(nums);
        // Output: 3
        System.out.println("The majority element is: " + result);
    }

}
