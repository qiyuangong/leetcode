## Remove Element


### 描述

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.


### 分析

无


### 代码

{% if book.java %}
{% codesnippet "./code/remove-element."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Remove Element
// Time Complexity: O(n), Space Complexity: O(1)
class Solution {
public:
    int removeElement(vector<int>& nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != target) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
};
```
{% endif %}


### 相关题目

* [Move Zeroes](move-zeroes.md)
