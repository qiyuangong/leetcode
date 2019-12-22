## Rectangle Area


### 描述

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

![](../images/rectangle-area.png)

Assume that the total area is never beyond the maximum possible value of int.


### 分析

简单平面几何。根据容斥原理：S(M ∪ N) = S(M) + S(N) - S(M ∩ N)，最关键的是求出相交部分的面积。


### 代码

{% if book.java %}
{% codesnippet "./code/rectangle-area."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
