## First Missing Positive


### 描述

Given an unsorted integer array, find the first missing positive integer.

For example,
Given `[1,2,0]` return `3`,
and `[3,4,-1,1]` return `2`.

Your algorithm should run in `O(n)` time and uses constant space.


### 分析

本质上是桶排序(bucket sort)，每当 `A[i]!= i+1` 的时候，将`A[i]`与`A[A[i]-1]`交换，直到无法交换为止，终止条件是 `A[i]== A[A[i]-1]`。


### 代码

{% if book.java %}
{% codesnippet "./code/first-missing-positive."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// First Missing Positive
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        bucket_sort(nums);
        
        for (int i = 0; i < nums.size(); ++i)
            if (nums[i] != (i + 1))
                return i + 1;
        return nums.size() + 1;
    }
private:
    static void bucket_sort(vector<int>& A) {
        const int n = A.size();
        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] > n || A[i] == A[A[i] - 1])
                    break;
                swap(A[i], A[A[i] - 1]);
            }
        }
    }
};
```
{% endif %}


### 相关题目

* [Sort Colors](../quick-sort/sort-colors.md)
