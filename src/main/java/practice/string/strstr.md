## Implement strStr()


### 描述

Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.


### 分析

暴力算法的复杂度是 `O(m*n)`，代码如下。更高效的的算法有KMP算法、Boyer-Mooer算法和Rabin-Karp算法。面试中暴力算法足够了，一定要写得没有BUG。


### 暴力匹配

{% codesnippet "./code/strstr-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### KMP

{% codesnippet "./code/strstr-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [String to Integer (atoi)](string-to-integer.md)
