## Maximum Product Subarray


### 描述

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array `[2,3,-2,4]`,
the contiguous subarray `[2,3]` has the largest product = `6`.


### 分析

这题跟“最大连续子序列和”非常类似，只不过变成了“最大连续子序列积”，所以解决思路也很类似。

仅仅有一个小细节需要注意，就是负负得正，两个负数的乘积是正数，因此我们不仅要跟踪最大值，还要跟踪最小值。


### 动规

{% codesnippet "./code/maximum-product-subarray."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Maximum Subarray](maximum-subarray.md)
* [Binary Tree Maximum Path Sum](../binary-tree/recursion/binary-tree-maximum-path-sum.md)
