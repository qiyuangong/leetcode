## Roman to Integer


### 描述

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


### 分析

从前往后扫描，用一个临时变量记录分段数字。

如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如`IV = 5 – 1`；否则，将当前值加入到结果中，然后开始下一段记录。比如`VI = 5 + 1, II=1+1`


### 代码

{% codesnippet "./code/roman-to-integer."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Integer to Roman](integer-to-roman.md)
