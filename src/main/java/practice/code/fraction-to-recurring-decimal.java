// Fraction to Recurring Decimal
// Time Complexity: ?, Space Complexity: ?
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        final StringBuilder result = new StringBuilder();
        // determine the sign
        if ((numerator < 0) ^ (denominator < 0)) result.append('-');

        // Integer.MIN_VALUE will overflow, so use long
        // Math.abs(MIN_VALUE) will overflow
        long n = numerator;
        n = Math.abs(n);
        long d = denominator;
        d = Math.abs(d);

        // append integral part
        result.append(String.valueOf(n / d));
        if (n % d == 0) return result.toString();
        result.append('.');

        final Map<Long, Integer> map = new HashMap<>();
        // simulate the division process
        for (long r = n % d; r != 0; r %= d) {
            // find a existed remainder, so we reach
            // the end of the repeating part
            if (map.containsKey(r)) {
                result.insert(map.get(r), "(");
                result.append(')');
                break;
            }

            map.put(r, result.length());

            r *= 10;
            result.append(Character.forDigit((int)(r/d), 10));
        }

        return result.toString();
    }
}