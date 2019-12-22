// Multiply Strings
// 9个字符对应一个 long
// 时间复杂度O(n*m)，空间复杂度O(n+m)
public class Solution {
    public String multiply(String num1, String num2) {
        BigInt bigInt1 = BigInt.fromString(num1);
        BigInt bigInt2 = BigInt.fromString(num2);
        BigInt result = BigInt.multiply(bigInt1, bigInt2);
        return result.toString();
    }

    // 9个字符对应一个 long
    static class BigInt {
        /** 一个数组元素对应9个十进制位，即数组是亿进制的
         * 因为 1000000000 * 1000000000 没有超过 2^63-1
         */
        final static int BIGINT_RADIX = 1000000000;
        final static int RADIX_LEN = 9;
        /** 万进制整数. */
        private final long[] digits;

        public BigInt(long[] digits) {
            this.digits = digits;
        }

        private static BigInt fromString(String s) {
            long[] digits;
            if (s.length() % RADIX_LEN == 0) {
                digits = new long[s.length() / RADIX_LEN];
            } else {
                digits = new long[s.length() / RADIX_LEN + 1];
            }
            for (int i = s.length(), k = 0; i > 0; i -= RADIX_LEN) {
                long tmp = 0;
                for (int j = Math.max(0, i - RADIX_LEN); j < i; ++j) {
                    tmp = tmp * 10 + Character.getNumericValue(s.charAt(j));
                }
                digits[k++] = tmp;
            }
            return new BigInt(digits);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(
                    Long.toString(digits[digits.length-1]));

            for (int i = digits.length - 2; i >= 0; --i) {
                sb.append(String.format("%0" + RADIX_LEN + "d", digits[i]));
            }
            return sb.toString();
        }

        public static BigInt multiply(BigInt x, BigInt y) {
            long[] z = new long[x.digits.length + y.digits.length];
            for (int i = 0; i < x.digits.length; ++i) {
                for (int j = 0; j < y.digits.length; ++j) {
                    z[i + j] += x.digits[i] * y.digits[j];
                    z[i + j + 1] += z[i + j] / BIGINT_RADIX;
                    z[i + j] %= BIGINT_RADIX;
                }
            }
            // find the first 0 from right to left
            int i = z.length - 1;
            for (; i > 0 && z[i] == 0; --i) /* empty */;

            if (i == z.length - 1) {
                return new BigInt(z);
            } else { // make a copy
                long[] tmp = new long[i + 1];
                System.arraycopy(z, 0, tmp, 0, i + 1);
                return new BigInt(tmp);
            }
        }
    }
}