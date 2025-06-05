package com.rdlts.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _88MergeSortedArrayTest {

    @Test
    void case1() {
        // 帮我设计测试用例
        _88MergeSortedArray solution = new _88MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void case2() {
        _88MergeSortedArray solution = new _88MergeSortedArray();
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void case3() {
        _88MergeSortedArray solution = new _88MergeSortedArray();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void case4() {
        _88MergeSortedArray solution = new _88MergeSortedArray();
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1, 2}, nums1);
    }

    @Test
    void case5() {
        _88MergeSortedArray solution = new _88MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }
}