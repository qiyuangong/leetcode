## Find Minimum in Rotated Sorted Array II

### 描述

Follow up for "Find Minimum in Rotated Sorted Array":

What if duplicates are allowed?


### 分析

同 [Find Minimum in Rotated Sorted Array](find-minimum-in-rotated-sorted-array.md) 类似，要判断“断层”在左边还是右边。

* 若`A[mid] < A[right]`，则区间`[mid,right]`一定递增，断层一定在左边
* 若`A[mid] > A[right]`，则区间`[left,mid]`一定递增，断层一定在右边
* 若`A[mid] == A[right]` 确定不了，这个时候，断层既可能在左边，也可能在右边，所以我们不能扔掉一半，不过这时，我们可以`--right`扔掉一个

本题还有另一种思路，

* 若`A[left] < A[mid]`，则区间`[left,mid]`一定递增，断层一定在右边
* 若`A[left] > A[mid]`，则区间`[mid,right]`一定递增，断层一定在左边
* 若`A[left] == A[mid]` 确定不了，这个时候，断层既可能在左边，也可能在右边，所以我们不能扔掉一半，不过这时，我们可以`++left`扔掉一

注意，第三种情况，我们认为可以`++left`扔掉一个，这个做法是不对的，因为数组被分成两段后，两段分别是递增的，`left`这个元素有可能是全局最小值，不能贸然扔掉。而在前一种思路中，`end`可以扔掉，因为`end`在右边，它的左边必然有小于或等于它的元素，所以可以放心`--end`。


### 代码

{% if book.java %}
{% codesnippet "./code/find-minimum-in-rotated-sorted-array-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Search in Rotated Sorted Array](search-in-rotated-sorted-array.md)
* [Search in Rotated Sorted Array II](search-in-rotated-sorted-array-ii.md)
* [Find Minimum in Rotated Sorted Array](find-minimum-in-rotated-sorted-array.md)
