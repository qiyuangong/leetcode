## Factorial Trailing Zeroes

### 描述

Given an integer `n`, return the number of trailing zeroes in `n!`.

Note: Your solution should be in logarithmic time complexity.


### 分析

对任意一个正整数n进行质因数分解，$$n = 2^x*3^y*5^z...$$ ，末尾0的个数M与2和5的个数即X、Z有关，每一对2和5都可以得到10，故`M=min(X,Z)`。又因为能被2整除的数出现的频率要比能被5整除的数出现的频率高，所以`M=Z`。所以只要计算出Z，就可以得到`n!`的末尾0的个数。


### 解法1

{% if book.java %}
```java
// Factorial Trailing Zeroes
// TLE
// Time Complexity: O(nlogn), Space Complexity: O(1)
public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;

        for (int i = 1; i <= n; ++i) {
            int j = i;
            while (j % 5 == 0) {
                ++result;
                j /= 5;
            }
        }
        return result;
    }
}
```
{% endif %}


### 解法2

上面的解法会超时，可以优化一下。

可以用公式计算出末尾0的个数，$$Z=N/5 + N/5^2 + N/5^3 + ...$$ ，$$N/5$$ 表示从1到N中能被5整除的数的个数，由于每个数都能贡献一个5，意味着能贡献一个0。$$N/5^2$$ 表示从1到N中能被 $$5^2$$ 整除的数的个数，每个数都能贡献2个5，意味着能贡献两个0，不过由于其中一次已经包含在 $$N/5$$ 中了，只能再贡献一个0，依次类推。

{% if book.java %}
{% codesnippet "./code/factorial-trailing-zeroes-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
