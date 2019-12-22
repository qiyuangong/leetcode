// Best Time to Buy and Sell Stock
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;  // 差价，也就是利润
        int cur_min = prices[0]; // 当前最小

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - cur_min);
            cur_min = Math.min(cur_min, prices[i]);
        }
        return profit;
    }
}