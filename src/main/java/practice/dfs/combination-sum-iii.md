## Combination Sum III


### 描述

Find all possible combinations of `k` numbers that add up to a number `n`, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

** Example 1**:

Input: `k`=3, `n`=7

Output: `[[1,2,4]]`

** Example 2**:

Input: `k`=3, `n`=9

Output: `[[1,2,6], [1,3,5], [2,3,4]]`


### 分析

这是一个多阶段问题，目标是求所有解，显然用深搜+剪枝，即回溯法。


### 代码

{% if book.java %}
{% codesnippet "./code/combination-sum-iii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Combination Sum](combination-sum.md)
* [Combination Sum II](combination-sum-ii.md)
