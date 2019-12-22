## Search in Rotated Sorted Array


### 描述

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.


### 分析

一个有序数组被循环右移，只可能有一下两种情况：

```
   7 │
 6   │
─────┼───────────
     │         5
     │       4
     │     3
     │   2
     │ 1
```

```
         7 │
       6   │
     5     │
   4       │
 3         │
───────────┼───────────      
           │   2
           │ 1
```

本题依旧可以用二分查找，难度主要在于左右边界的确定。仔细观察上面两幅图，我们可以得出如下结论：

如果`A[left] <= A[mid]`,那么`[left,mid]` 一定为单调递增序列。


### 代码

{% if book.java %}
```java
// Search in Rotated Sorted Array
// Time Complexity: O(log n)，Space Complexity: O(1)
public class Solution {
    public int search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            }
        }
        return -1;
    }
};
```
{% endif %}


{% if book.cpp %}
```cpp
// Search in Rotated Sorted Array
// Time Complexity: O(log n)，Space Complexity: O(1)
class Solution {
public:
    int search(const vector<int>& nums, int target) {
        int first = 0, last = nums.size();
        while (first != last) {
            const int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            }
        }
        return -1;
    }
};
```
{% endif %}


### 相关题目

* [Search in Rotated Sorted Array II](search-in-rotated-sorted-array-ii.md)
* [Find Minimum in Rotated Sorted Array](find-minimum-in-rotated-sorted-array.md)
* [Find Minimum in Rotated Sorted Array II](find-minimum-in-rotated-sorted-array-ii.md)
