## Ugly Number


### 描述

Write a function to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.


### 分析

思路很简单，把`n`里面的2,3,5 全部消掉，看最后能不能剩下1。


### 代码

{% if book.java %}
{% codesnippet "./code/ugly-number."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Ugly Number II](ugly-number-ii.md)
