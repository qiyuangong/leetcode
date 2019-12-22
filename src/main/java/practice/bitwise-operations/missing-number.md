## Missing Number

### 描述

Given an array containing `n` distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.

For example,

Given nums = `[0, 1, 3]` return `2`.

**Note**:

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


### 分析

本题的意思是，从1到n的整数，其中某个数丢失了，替代它的是0。要我们找出这个丢失的数。

方法1，我们可以用公式计算出从1到n的和，减去实际数组的总和，差值就是那个丢失的数。

方法2，利用异或位运算，把数组中的每一个数，与1到n进行按位异或，最后剩下的，就是丢失的数。

方法3，二分查找。首先把数组排序，设中间元素为`nums[mid]`，如果`nums[mid]`的值大于其下标，说明丢失的数字在左边，反之则在右边。时间复杂度`O(nlogn)`，比前面两个方法慢，但是如果题目给的数组是事先排好序的，那么复杂度就是`O(log n)`，所以这个方法还是很有意义的。


### 解法1

{% if book.java %}
{% codesnippet "./code/missing-number-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法2

{% if book.java %}
{% codesnippet "./code/missing-number-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法3

{% if book.java %}
{% codesnippet "./code/missing-number-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
