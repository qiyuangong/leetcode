## House Robber II


### 描述

This time, all houses at this place are **arranged in a circle**. 


### 分析

如果抢劫第一家，则不可以抢最后一家；否则，可以抢最后一家。因此，这个问题就转化成为了两趟动规，可以复用 "House Robber" 的代码。


### 代码

{% if book.java %}
{% codesnippet "./code/house-robber-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
