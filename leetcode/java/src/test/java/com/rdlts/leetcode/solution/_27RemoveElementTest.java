package com.rdlts.leetcode.solution;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class _27RemoveElementTest {

    @Test
    void testRemoveElement_case1() {
        _27RemoveElement solution = new _27RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = solution.removeElement(nums, val);
        assertEquals(2, k);
        int[] expectedNums = {2, 2};
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void testRemoveElement_case2() {
        _27RemoveElement solution = new _27RemoveElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = solution.removeElement(nums, val);
        assertEquals(5, k);
        int[] expectedNums = {0,1,4,0,3};
        Collection<Integer> col = Arrays.stream(Arrays.copyOf(nums, k)).boxed().toList();
        Collection<Integer> expectedCol = Arrays.stream(expectedNums).boxed().toList();
        assertTrue(col.containsAll(expectedCol));
    }

    @Test
    void testRemoveElement_case3() {
        _27RemoveElement solution = new _27RemoveElement();
        int[] nums = {2, 2, 2, 2};
        int val = 2;
        int k = solution.removeElement(nums, val);
        assertEquals(0, k);
    }

    @Test
    void testRemoveElement_case4() {
        _27RemoveElement solution = new _27RemoveElement();
        int[] nums = {1, 3, 5, 7};
        int val = 2;
        int k = solution.removeElement(nums, val);
        assertEquals(4, k);
        int[] expectedNums = {1, 3, 5, 7};
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void testRemoveElement_case5() {
        _27RemoveElement solution = new _27RemoveElement();
        int[] nums = {};
        int val = 1;
        int k = solution.removeElement(nums, val);
        assertEquals(0, k);
    }

}