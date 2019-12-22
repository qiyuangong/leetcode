## Find Minimum in Rotated Sorted Array

### 描述

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Find the minimum element.

You may assume no duplicate exists in the array.


### 分析

从左向右扫描，扫描到的第一个逆序的位置，肯定是原始数组中第一个元素，时间复杂度`O(n)`。

不过本题依旧可以用二分查找，最关键的是要判断那个“断层”是在左边还是右边。

* 若`A[mid] < A[right]`，则区间`[mid,right]`一定递增，断层一定在左边
* 若`A[mid] > A[right]`，则区间`[left,mid]`一定递增，断层一定在右边
* `nums[mid] == nums[right]`，这种情况不可能发生，因为数组是严格单调递增的，不存在重复元素

### 代码

{% if book.java %}
{% codesnippet "./code/find-minimum-in-rotated-sorted-array."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Search in Rotated Sorted Array](search-in-rotated-sorted-array.md)
* [Search in Rotated Sorted Array II](search-in-rotated-sorted-array-ii.md)
* [Find Minimum in Rotated Sorted Array II](find-minimum-in-rotated-sorted-array-ii.md)
