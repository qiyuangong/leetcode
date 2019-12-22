## Largest Number


### 描述

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given `[3, 30, 34, 5, 9]`, the largest formed number is `9534330`.

Note: The result may be very large, so you need to return a string instead of an integer.


### 分析

这题可以先把每个整数变成字符串，得到一个字符串数组，然后把这个数组按特定规则排个序，顺序输出即可。


### 代码

{% if book.java %}
{% codesnippet "./code/largest-number."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
