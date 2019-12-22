// Unique Paths
// 数学公式
public class Solution {
    public int uniquePaths(int m, int n) {
        // max 可以防止n和k差距过大，从而防止combination()溢出
        return (int)combination(m+n-2, Math.max(m-1, n-1));
    }
    // 求阶乘, n!/(start-1)!，即 n*(n-1)...start，要求 n >= 1
    private static long factor(int n, int start) {
        long  ret = 1;
        for(int i = start; i <= n; ++i)
            ret *= i;
        return ret;
    }
    private static long factor(int n) {
        return factor(n, 1);
    }
    // 求组合数 C_n^k
    private static long combination(int n, int k) {
        // 常数优化
        if (k == 0) return 1;
        if (k == 1) return n;

        long ret = factor(n, k+1);
        ret /= factor(n - k);
        return ret;
    }
}