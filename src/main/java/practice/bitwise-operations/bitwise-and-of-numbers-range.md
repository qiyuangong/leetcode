## Bitwise AND of Numbers Range


### 描述

Given a range `[m, n]` where `0 <= m <= n <= 2147483647`, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range `[5, 7]`, you should return `4`.


### 分析

最简单的解法，遍历所有数，不断进行按位与，时间复杂度`O(n)`。这个做法太慢，不可接受。

先观察 `[5,7]`这个例子，`5,6,7`的二进制如下：

```
101
110
111
```

三个数按位与后结果为0，仔细观察这个过程我们可以得出，最后的结果是该范围内所有数的左边的共同部分，即公共左边首部(left header)。

我们再举一个更大的例子来感受一下，例如`[26,30]`，这些数的二进制如下：

```
11010
11011
11100
11101
11110
```

最后的结果是`11000`，果然是公共左边首部。

发现了规律后，这题就简单了，我们只需要写代码找到公共左边首部即可。


### 解法1

{% if book.java %}
{% codesnippet "./code/bitwise-and-of-numbers-range-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法2

{% if book.java %}
{% codesnippet "./code/bitwise-and-of-numbers-range-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
