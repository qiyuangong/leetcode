## Remove Duplicates from Sorted Array II

### 描述

Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

For example, given sorted array `A = [1,1,1,2,2,3]`, your function should return length = `5`, and A is now `[1,1,2,2,3]`


### 分析

加一个变量记录一下元素出现的次数即可。这题因为是已经排序的数组，所以一个变量即可解决。如果是没有排序的数组，则需要引入一个hashmap来记录出现次数。


### 代码1

{% if book.cpp %}
```cpp
// Remove Duplicates from Sorted Array II
// Time complexity: O(n), Space Complexity: O(1)
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 2) return nums.size();

        int index = 2;
        for (int i = 2; i < nums.size(); i++){
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }

        return index;
    }
};
```
{% endif %}

{% if book.java %}
```java
// Remove Duplicates from Sorted Array II
// Time complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }

        return index;
    }
};
```
{% endif %}


### 代码2

下面是一个更简洁的版本。上面的代码略长，不过扩展性好一些，例如将`occur < 2`改为`occur < 3`，就变成了允许重复最多3次。

{% if book.java %}
{% codesnippet "./code/remove-duplicates-from-sorted-array-ii-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Remove Duplicates from Sorted Array II
// Time Complexity: O(n), Space Complexity: O(1)
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        const int n = nums.size();
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && i < n - 1 && nums[i] == nums[i - 1] && nums[i] == nums[i + 1])
                continue;

            nums[index++] = nums[i];
        }
        return index;
    }
};
```
{% endif %}

### 相关题目

* [Remove Duplicates from Sorted Array](remove-duplicates-from-sorted-array.md)
