// Best Time to Buy and Sell Stock II
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) sum += diff;
        }
        return sum;
    }
}