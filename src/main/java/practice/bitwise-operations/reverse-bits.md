## Reverse Bits

### 描述

Reverse bits of a given 32 bits unsigned integer.

For example, given input `43261596` (represented in binary as `00000010100101000001111010011100`), return `964176192` (represented in binary as `00111001011110000010100101000000`).

**Follow up**: If this function is called many times, how would you optimize it?

### 分析

最简单直接的做法，从右向左把一位位取出来，添加到新生成的整数的最低位即可。

第二个简单的方法，左右不断交换位，直到相遇。


### 解法1

{% if book.java %}
{% codesnippet "./code/reverse-bits-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法2

{% if book.java %}
{% codesnippet "./code/reverse-bits-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
