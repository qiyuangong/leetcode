// Best Time to Buy and Sell Stock with Cooldown
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int curSell = 0;   // sell[i]
        int prevSell = 0;  // sell[i-2]
        int buy = -prices[0]; // buy[i]

        for (int i = 1; i < prices.length; ++i) {
            final int tmp = curSell;
            curSell = Math.max(curSell, buy + prices[i]);
            buy = Math.max(buy, (i > 1 ? prevSell : 0) - prices[i]);
            prevSell = tmp;
        }
        return curSell;
    }
}