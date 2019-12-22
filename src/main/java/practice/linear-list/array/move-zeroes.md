## Move Zeroes

### 描述

Given an array `nums`, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given `nums = [0, 1, 0, 3, 12]`, after calling your function, nums should be `[1, 3, 12, 0, 0]`.

**Note**:

1. You must do this in-place without making a copy of the array.
1. Minimize the total number of operations.


### 分析

这题跟 "Remove Element" 思路一模一样，只是最后要把后半截设置为0。

### 代码

{% if book.java %}
{% codesnippet "./code/move-zeroes."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Remove Element](remove-element.md)
