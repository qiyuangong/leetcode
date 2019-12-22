## Search Insert Position



### 描述

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

```
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
```


### 分析

即`std::lower_bound()`。


### 代码

{% if book.java %}
{% codesnippet "./code/search-insert-position."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


{% if book.cpp %}
```cpp
// Search Insert Position
// 重新实现 lower_bound
// 时间复杂度O(logn)，空间复杂度O(1)
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        return distance(nums.begin(), lower_bound(nums.begin(), nums.end(), target));
    }

    template<typename ForwardIterator, typename T>
    ForwardIterator lower_bound (ForwardIterator first,
            ForwardIterator last, T value) {
        while (first != last) {
            auto mid = next(first, distance(first, last) / 2);

            if (value > *mid)   first = ++mid;
            else                last = mid;
        }

        return first;
    }
};
```
{% endif %}


### 相关题目

* [Search for a Range](search-for-a-range.md)
