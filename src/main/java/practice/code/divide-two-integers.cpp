// Divide Two Integers
// 时间复杂度O(logn)，空间复杂度O(1)
class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 0) return INT_MAX;

        // 当 dividend = INT_MIN，divisor = -1时，结果会溢出
        if (dividend == INT_MIN) {
            if (divisor == -1) return INT_MAX;
            else if (divisor < 0)
                return 1 + divide(dividend - divisor, divisor);
            else
                return - 1 + divide((dividend + divisor), divisor);
        }
        if(divisor == INT_MIN){
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
                if (c < INT_MAX / 2) { // prevent overflow
                    ++i;
                    c <<= 1;
                }
            }
        }

        return ((dividend^divisor) >> 31) ? (-result) : (result);
    }
};