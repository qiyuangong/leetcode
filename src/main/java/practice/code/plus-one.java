// Plus One
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int[] plusOne(int[] digits) {
        return add(digits, 1);
    }
    private static int[] add(int[] digits, int digit) {
        int c = digit;  // carry, 进位

        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }

        if (c > 0) { // assert (c == 1)
            int[] tmp = new int[digits.length + 1];
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            tmp[0] = c;
            return tmp;
        } else {
            return digits;
        }
    }
};