## Fraction to Recurring Decimal

### 描述

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

* Given numerator = 1, denominator = 2, return "0.5".
* Given numerator = 2, denominator = 1, return "2".
* Given numerator = 2, denominator = 3, return "0.(6)".


### 分析

这题的难点是如何找到无限循环的那一段。仔细回想一下人脑进行除法的过程，会发现，当一个余数第二次重复出现时，就说明小数点后开始无限循环了。


### 代码

{% if book.java %}
```java
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
```
{% endif%}
