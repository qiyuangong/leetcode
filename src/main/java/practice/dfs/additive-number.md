## Additive Number

### 描述

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain **at least** three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:

`"112358"` is an additive number because the digits can form an additive sequence: `1, 1, 2, 3, 5, 8`.

    1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

`"199100199"` is also an additive number, the additive sequence is: `1, 99, 100, 199`.

    1 + 99 = 100, 99 + 100 = 199

Note: Numbers in the additive sequence cannot have leading zeros, so sequence `1, 2, 03` or `1, 02, 3` is invalid.

Given a string containing only digits `'0'-'9'`, write a function to determine if it's an additive number.

**Follow up**:

How would you handle overflow for very large input integers?


### 分析

这是一个多阶段决策问题，且必须走到字符串最后一个字符才能得出结论，因此适合用深搜或DP。

再仔细想一下状态转换图，每次索引变化一下，就跟之前的完全没有重复，因此状态转换图是一颗树，不是DAG，因此不存在重叠子问题，因此排除DP，本题应该用深搜。


### 代码

{% if book.java %}
```java
// Additive Number
// 多入口深搜
// 时间复杂度O(n^3)，空间复杂度O(1)
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; ++i) {
            if (num.charAt(0) == '0' && i > 1) continue;
            for (int j = i + 1; j < num.length(); ++j) {
                if (num.charAt(i) == '0' && j - i > 1) continue;
                if (dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    // 判断从 [i, j) 和 [j, k) 出发,能否走到尽头
    private static boolean dfs(String num, int i, int j, int k) {
        long num1 = Long.parseLong(num.substring(i, j));
        long num2 = Long.parseLong(num.substring(j, k));
        final String addition = String.valueOf(num1 + num2);

        if (!num.substring(k).startsWith(addition)) return false;
        if (k + addition.length() == num.length()) return true;
        return dfs(num, j, k, k + addition.length());
    }
}
```
{% endif %}
