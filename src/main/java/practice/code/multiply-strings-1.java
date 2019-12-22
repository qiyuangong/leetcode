// Multiply Strings
// 一个字符对应一个int
// 时间复杂度O(n*m)，空间复杂度O(n+m)
public class Solution {
    public String multiply(String num1, String num2) {
        BigInt bigInt1 = new BigInt(num1);
        BigInt bigInt2 = new BigInt(num2);
        BigInt result = BigInt.multiply(bigInt1, bigInt2);
        return result.toString();
    }

    // 一个字符对应一个int
    static class BigInt {
        private final int[] d;

        public BigInt(String s) {
            this.d = fromString(s);
        }
        public BigInt(int[] d) {
            this.d = d;
        }

        private static int[] fromString(String s) {
            int[] d = new int[s.length()];
            for (int i = s.length() - 1, j = 0; i >= 0; --i)
                d[j++] = Character.getNumericValue(s.charAt(i));
            return d;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            for (int i = d.length - 1; i >= 0; --i) {
                sb.append(Character.forDigit(d[i], 10));
            }
            return sb.toString();
        }

        public static BigInt multiply(BigInt x, BigInt y) {
            int[] z = new int[x.d.length + y.d.length];
            for (int i = 0; i < x.d.length; ++i) {
                for (int j = 0; j < y.d.length; ++j) {
                    z[i + j] += x.d[i] * y.d[j];
                    z[i + j + 1] += z[i + j] / 10;
                    z[i + j] %= 10;
                }
            }
            // find the first 0 from right to left
            int i = z.length - 1;
            for (; i > 0 && z[i] == 0; --i) /* empty */;

            if (i == z.length - 1) {
                return new BigInt(z);
            } else { // make a copy
                int[] tmp = new int[i + 1];
                System.arraycopy(z, 0, tmp, 0, i + 1);
                return new BigInt(tmp);
            }
        }
    }
}