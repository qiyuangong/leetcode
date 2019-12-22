// Unique Paths
// 数学公式
class Solution {
public:
    int uniquePaths(int m, int n) {
        // max 可以防止n和k差距过大，从而防止combination()溢出
        return combination(m+n-2, max(m-1, n-1));
    }
private:
    typedef long long int64_t;
    // 求阶乘, n!/(start-1)!，即 n*(n-1)...start，要求 n >= 1
    static int64_t factor(int n, int start = 1) {
        int64_t  ret = 1;
        for(int i = start; i <= n; ++i)
            ret *= i;
        return ret;
    }
    // 求组合数 C_n^k
    static int64_t combination(int n, int k) {
        // 常数优化
        if (k == 0) return 1;
        if (k == 1) return n;

        int64_t ret = factor(n, k+1);
        ret /= factor(n - k);
        return ret;
    }
};