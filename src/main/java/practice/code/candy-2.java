// Candy
// 备忘录法，时间复杂度O(n)，空间复杂度O(n)
// java.lang.StackOverflowError
public class Solution {
    public int candy(int[] ratings) {
        final int[] f = new int[ratings.length];
        int sum = 0;
        for (int i = 0; i < ratings.length; ++i)
            sum += solve(ratings, f, i);
        return sum;
    }
    int solve(int[] ratings, int[] f, int i) {
        if (f[i] == 0) {
            f[i] = 1;
            if (i > 0 && ratings[i] > ratings[i - 1])
                f[i] = Math.max(f[i], solve(ratings, f, i - 1) + 1);
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1])
                f[i] = Math.max(f[i], solve(ratings, f, i + 1) + 1);
        }
        return f[i];
    }
}