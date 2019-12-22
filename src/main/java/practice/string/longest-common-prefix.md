## Longest Common Prefix


### 描述

Write a function to find the longest common prefix string amongst an array of strings.


### 分析

从位置0开始，对每一个位置比较所有字符串，直到遇到一个不匹配。


### 纵向扫描

{% codesnippet "./code/longest-common-prefix-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 横向扫描

{% codesnippet "./code/longest-common-prefix-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
