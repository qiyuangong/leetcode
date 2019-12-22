// Candy
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int candy(int[] ratings) {
        final int n = ratings.length;
        final int[] increment = new int[n];

        // 左右各扫描一遍
        for (int i = 1, inc = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                increment[i] = Math.max(inc++, increment[i]);
            else
                inc = 1;
        }

        for (int i = n - 2, inc = 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                increment[i] = Math.max(inc++, increment[i]);
            else
                inc = 1;
        }
        // 初始值为n，因为每个小朋友至少一颗糖
        int sum = n;
        for (int i : increment) sum += i;
        return sum;
    }
};