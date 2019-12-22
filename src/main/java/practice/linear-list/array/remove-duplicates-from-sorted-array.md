## Remove Duplicates from Sorted Array

### 描述

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example, Given input array `A = [1,1,2]`,

Your function should return length = 2, and `A` is now `[1,2]`.


### 分析

无


### 代码

{% if book.java %}
{% codesnippet "./code/remove-duplicates-from-sorted-array."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Remove Duplicates from Sorted Array
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;

        int index = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != nums[index - 1])
                nums[index++] = nums[i];
        }
        return index;
    }
};
```
{% endif %}

### 相关题目

* [Remove Duplicates from Sorted Array II](remove-duplicates-from-sorted-array-ii.md)
