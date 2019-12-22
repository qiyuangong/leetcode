## Rotate List



### 描述

Given a list, rotate the list to the right by `k` places, where `k` is non-negative.

For example:
Given `1->2->3->4->5->nullptr` and `k = 2`, return `4->5->1->2->3->nullptr`.


### 分析

先遍历一遍，得出链表长度`len`，注意`k`可能大于`len`，因此令`k %= len`。将尾节点next指针指向首节点，形成一个环，接着往后跑`len-k`步，从这里断开，就是要求的结果了。


### 代码

{% codesnippet "./code/rotate-list."+book.suffix, language=book.suffix %}{% endcodesnippet %}
