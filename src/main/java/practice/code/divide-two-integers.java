// Divide Two Integers
// 时间复杂度O(logn)，空间复杂度O(1)
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;

        // 当 dividend = INT_MIN，divisor = -1时，结果会溢出
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor < 0)
                return 1 + divide(dividend - divisor, divisor);
            else
                return - 1 + divide((dividend + divisor), divisor);
        }
        if(divisor == Integer.MIN_VALUE){
            return dividend == divisor ? 1 : 0;
        }

        int a = dividend > 0 ? dividend : -dividend;
        int b = divisor > 0 ? divisor : -divisor;

        int result = 0;
        while (a >= b) {
            int c = b;
            for (int i = 0; a >= c;) {
                a -= c;
                result += 1 << i;
                if (c < Integer.MAX_VALUE / 2) { // prevent overflow
                    ++i;
                    c <<= 1;
                }
            }
        }

        return ((dividend^divisor) >> 31) != 0 ? (-result) : (result);
    }
}