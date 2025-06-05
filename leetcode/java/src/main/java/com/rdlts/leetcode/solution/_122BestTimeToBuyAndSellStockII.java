package com.rdlts.leetcode.solution;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

 On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

 Find and return the maximum profit you can achieve.



 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 Total profit is 4 + 3 = 7.
 Example 2:

 Input: prices = [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Total profit is 4.
 Example 3:

 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

 */
public class _122BestTimeToBuyAndSellStockII {

    // 矩阵 动态规划

    /**
        7	1	 5	 3	 6	 4
     7	0	-6	-2	-4	-1	-3
     1		 0	 4	-2	 3	-2
     5			 0	-2	 1	-1
     3				 0	 3	 1
     6					 0	-2
     4						 0
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    public static void main(String[] args) {
        _122BestTimeToBuyAndSellStockII solution = new _122BestTimeToBuyAndSellStockII();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        // Output: 7
        System.out.println(solution.maxProfit(prices1));

        int[] prices2 = {1, 2, 3, 4, 5};
        // Output: 4
        System.out.println(solution.maxProfit(prices2));

        int[] prices3 = {7, 6, 4, 3, 1};
        // Output: 0
        System.out.println(solution.maxProfit(prices3));
    }
}
