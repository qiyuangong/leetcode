## Sort Colors


### 描述

Given an array with `n` objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

**Follow up**:

A rather straight forward solution is a two-pass algorithm using counting sort.

First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?


### 分析

由于0, 1, 2 非常紧凑，首先想到计数排序(counting sort)，但需要扫描两遍，不符合题目要求。

由于只有三种颜色，可以设置两个index，一个是red的index，一个是blue的index，两边往中间走。时间复杂度`O(n)`，空间复杂度`O(1)`。

第3种思路，利用快速排序里 partition 的思想，第一次将数组按0分割，第二次按1分割，排序完毕，可以推广到`n`种颜色，每种颜色有重复元素的情况。


### 代码1

{% if book.java %}
{% codesnippet "./code/sort-colors-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Sort Colors
// Counting Sort
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    void sortColors(vector<int>& A) {
        int counts[3] = { 0 }; // 记录每个颜色出现的次数

        for (int i = 0; i < A.size(); i++)
            counts[A[i]]++;

        for (int i = 0, index = 0; i < 3; i++)
            for (int j = 0; j < counts[i]; j++)
                A[index++] = i;

    }
};
```
{% endif %}

### 代码2

{% if book.java %}
{% codesnippet "./code/sort-colors-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Sort Colors
// 双指针，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    void sortColors(vector<int>& A) {
        // 一个是red的index，一个是blue的index，两边往中间走
        int red = 0, blue = A.size() - 1;

        for (int i = 0; i < blue + 1;) {
            if (A[i] == 0)
                swap(A[i++], A[red++]);
            else if (A[i] == 2)
                swap(A[i], A[blue--]);
            else
                i++;
        }
    }
};
```
{% endif %}


### 代码3

{% if book.java %}
{% codesnippet "./code/sort-colors-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Sort Colors
// 重新实现 partition()
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    void sortColors(vector<int>& nums) {
        partition(partition(nums.begin(), nums.end(), bind1st(equal_to<int>(), 0)),
                 nums.end(), bind1st(equal_to<int>(), 1));
    }
private:
    template<typename ForwardIterator, typename UnaryPredicate>
    ForwardIterator partition(ForwardIterator first, ForwardIterator last,
            UnaryPredicate pred) {
        auto pos = first;

        for (; first != last; ++first)
            if (pred(*first))
                swap(*first, *pos++);

        return pos;
    }
};
```
{% endif %}


### 相关题目

* [First Missing Positive](../bucket-sort/first-missing-positive.md)
