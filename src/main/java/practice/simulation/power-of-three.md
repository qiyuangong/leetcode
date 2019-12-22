## Power of Three


### 描述

Given an integer, write a function to determine if it is a power of three.

**Follow up**:

Could you do it without using any loop / recursion?


### 分析

最简单的方法，不断除以3，看最后能否得到1。

如果不用循环和递归，那么就需要找数学方法了。最简单的，我们可以把该整数对3取对数，如果结果是整数，说明该整数是3的幂。


### 代码

{% if book.java %}
{% codesnippet "./code/power-of-three."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
