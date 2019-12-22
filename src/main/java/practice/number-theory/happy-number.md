## Happy Number


### 描述

Write a function to determine if a number is "happy number".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

**Example**: 19 is a happy number

$$1^2 + 9^2 = 82$$

$$8^2 + 2^2 = 68$$

$$6^2 + 8^2 = 100$$

$$1^2 + 0^2 + 0^2 = 1$$


### 分析

这题找到规律后就简单了。如果右边的出现了某个重复的数，但不是1，说明会无限循环下去，这个数就不是快乐数，如果是1，则是快乐数。


### 代码

{% if book.java %}
```java
// Happy Number
// Time complexity: ?, Space complexity: ?
public class Solution {
    public boolean isHappy(int n) {
        final Set<Integer> existed = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (existed.contains(sum)) {
                return sum == 1;
            } else {
                existed.add(sum);
                n = sum;
            }
        }
    }
}
```
{% endif %}
