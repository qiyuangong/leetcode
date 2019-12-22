## Search in Rotated Sorted Array II


### 描述

Follow up for "Search in Rotated Sorted Array": What if **duplicates** are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


### 分析

允许重复元素，则上一题中如果`A[left] <= A[mid]`,那么`[left,mid]`为递增序列的假设就不能成立了，比如`[1,3,1,1,1]`。

既然`A[left] <= A[mid]`不能确定递增，那就把它拆分成两个条件：

* 若`A[left] < A[mid]`，则区间`[left,mid]`一定递增
* 若`A[left] == A[mid]` 确定不了，那就`left++`，往下看一步即可。


### 代码

{% if book.java %}
```java
// Search in Rotated Sorted Array II
// Time Complexity: O(n)，Space Complexity: O(1)
public class Solution {
    public boolean search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                //skip duplicate one
                first++;
        }
        return false;
    }
};
```
{% endif %}


{% if book.cpp %}
```cpp
// Search in Rotated Sorted Array II
// Time Complexity: O(n)，Space Complexity: O(1)
class Solution {
public:
    bool search(const vector<int>& nums, int target) {
        int first = 0, last = nums.size();
        while (first != last) {
            const int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                //skip duplicate one
                first++;
        }
        return false;
    }
};
```
{% endif %}


### 相关题目

* [Search in Rotated Sorted Array](search-in-rotated-sorted-array.md)
* [Find Minimum in Rotated Sorted Array](find-minimum-in-rotated-sorted-array.md)
* [Find Minimum in Rotated Sorted Array II](find-minimum-in-rotated-sorted-array-ii.md)
