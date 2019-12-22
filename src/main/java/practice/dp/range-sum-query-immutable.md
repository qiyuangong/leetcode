## Range Sum Query - Immutable


### 描述

Given an integer array `nums`, find the sum of the elements between indices `i` and `j` (`i ≤ j`), inclusive.

**Example**:

Given `nums = [-2, 0, 3, -5, 2, -1]`

```
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**Note**:

* You may assume that the array does not change.
* There are many calls to sumRange function.


### 分析

令状态`f[i]`为0到`i`元素之间的和，则状态转移方程为 `f[i] = f[i-1] + nums[i]`。`f[i]`本质上是累加和，有了`f[i]`，则范围[i,j]之间的和等于`f[j] - f[i-1]`。


### 代码

{% if book.java %}
{% codesnippet "./code/range-sum-query-immutable."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Range Sum Query 2D - Immutable](range-sum-query-2d-immutable.md)
* [Range Sum Query - Mmutable](../binary-tree/segment-tree/range-sum-query-mutable.md)
