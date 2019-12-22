## Valid Anagram


### 描述

Given two strings `s` and `t`, write a function to determine if `t` is an anagram of `s`.

For example,

s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

**Note**:

You may assume the string contains only lowercase alphabets.


### 分析

首先能够想到的是，为`s`和`t`分别建立一个HashMap，统计每个字母出现的次数，比较两个HashMap是否相等。时间复杂度`O(n)`，空间复杂度`O(n)`，`n`为字符串长度。

如果面试官要求空间复杂度均为`O(1)`，怎么办？

注意这题的字符串只包含小写的字母，意味着只有从`a-z`的26个字母，于是我们可以为`s`和`t`开一个长度为26的整数数组来代替哈希表，此时额外空间为固定长度的两个数组，因此为`O(1)`。这是这题比较狡诈的地方。


### 代码

{% if book.java %}
{% codesnippet "./code/valid-anagram."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
