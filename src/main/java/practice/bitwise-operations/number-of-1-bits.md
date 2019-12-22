## Number of 1 Bits


### 描述

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer `11` has binary representation `00000000000000000000000000001011`, so the function should return 3.


### 分析

最直接的方法，做32次右移，统计出1的个数。

第二个方法，来自 "Hacker's Delight" 这本书。

{% if book.java %}
使用Java解题时，需要注意：

1. 输入值n可能为负数，但应视其为无符号整数，因为Java中实际上是没有无符号整数的
2. 使用无符号右移操作符`>>>`，可以忽略符号位
{% endif %}


### 解法1

{% if book.java %}
{% codesnippet "./code/number-of-1-bits-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

### 解法2

{% if book.java %}
{% codesnippet "./code/number-of-1-bits-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
