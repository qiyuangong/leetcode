## Merge Two Sorted Arrays


### 描述

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.


### 分析

无


### 代码

{% if book.java %}
{% codesnippet "./code/merge-two-sorted-arrays."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Merge Sorted Array
// 时间复杂度O(m+n)，空间复杂度O(1)
class Solution {
public:
    void merge(vector<int>& A, int m, vector<int>& B, int n) {
        int ia = m - 1, ib = n - 1, icur = m + n - 1;
        while(ia >= 0 && ib >= 0) {
            A[icur--] = A[ia] >= B[ib] ? A[ia--] : B[ib--];
        }
        while(ib >= 0) {
            A[icur--] = B[ib--];
        }
    }
};
```
{% endif %}


### 相关题目

* [Merge Two Sorted Lists](merge-two-sorted-lists.md)
* [Merge k Sorted Lists](merge-k-sorted-lists.md)
