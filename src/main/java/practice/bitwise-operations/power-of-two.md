## Power of Two


### 描述

Given an integer, write a function to determine if it is a power of two.


### 分析

如果是2的幂，则二进制的所有位中，有且仅有一个1。

可以复用 "Number of 1 Bits" 中的函数，计算出1的个数，如果为1，则返回true, 不为1，返回 false。

还有更巧妙的办法。如果一个数是2的幂，则它的二进制最高位必然为1，其余为0，此时如果我们减1的话，最高位降为0，其余位变为1，如果把两个数按位与，结果必然为0。


### 代码

{% if book.java %}
{% codesnippet "./code/power-of-two."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
