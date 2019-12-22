## H-Index


### 描述

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the [definition of h-index on Wikipedia](https://en.wikipedia.org/wiki/H-index): "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given `citations = [3, 0, 6, 1, 5]`, which means the researcher has 5 papers in total and each of them had received `3, 0, 6, 1, 5` citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

**Note**: If there are several possible values for `h`, the maximum one is taken as the h-index.


### 分析

H-Index的含义是，如果一个人发表的所有论文中，有`h`篇论文分别被引用了至少`h`次，那么他的H-Index就是`h`。

思路一：先从大到小排序，然后从前往后扫描，如果当前文章数（即当前下标+1）等于值本身，则返回当前文章数作为 h-index；如果当前文章数大于值本身，则返回当前文章数-1作为H-Index, 因为当前文章的引用数小于当前文章数，不能算在内。时间复杂度$$O(n\log{}n$$，空间复杂度O(1)。

思路二：跟思路一类似，不过排序算法换成了计数排序。有一个小技巧，因为H-Index最大不可能超过论文综述，所以我们只需要开一个长度为`n+1`的数组，如果某篇论文的引用数超过了`n`，就将其当做`n`。


### 代码1 全排序

{% if book.java %}
{% codesnippet "./code/h-index-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 代码2 计数排序

{% if book.java %}
{% codesnippet "./code/h-index-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [H-Index II](../../search/h-index-ii.md)
