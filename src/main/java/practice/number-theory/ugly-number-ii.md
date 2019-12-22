## Ugly Number II


### 描述

Write a function to find the `n`-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

**Hint**:

1. The naive approach is to call `isUgly()` for every number until you reach the `n`-th one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
1. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
1. The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: $$L_1$$, $$L_2$$, and $$L_3$$.
1. Assume you have $$U_k$$, the $$k^{th}$$ ugly number. Then $$U_{k+1}$$ must be $$Min(L_1 * 2, L_2 * 3, L_3 * 5)$$.


### 分析

根据提示中的信息，我们知道丑陋序列可以拆分成3个子序列：

1. 1x2, 2x2, 3x2, 4x2, 5x2, ...
1. 1x3, 2x3, 3x3, 4x3, 5x3, ...
1. 1x5, 2x5, 3x5, 4x5, 5x5, ...

每次从三个列表中取出当前最小的那个加入序列，直到第`n`个为止。


### 代码

{% if book.java %}
{% codesnippet "./code/ugly-number-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Ugly Number](ugly-number.md)
* [Super Ugly Number](super-ugly-number.md)
