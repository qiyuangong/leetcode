// Best Time to Buy and Sell Stock IV
// Time Complexity: O(nk), Space Complexity: O(nk)
public class Solution {
    public int maxProfit(final int k, final int[] prices) {
        if (prices.length < 2 || k < 1) return 0;
        if (k >= prices.length) return maxProfit(prices);

        final int[][] local = new int[prices.length][k + 1];
        final int[][] global = new int[prices.length][k + 1];

        for (int i = 1; i < prices.length; i++) {
            final int diff = prices[i] - prices[i - 1];
            for (int j = 1; j < k+1; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }

    // Best Time to Buy and Sell Stock II
    public static int maxProfit(final int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) sum += diff;
        }
        return sum;
    }
}