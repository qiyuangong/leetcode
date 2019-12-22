## Reverse Linked List


### 描述

Reverse a singly linked list.


### 分析

用三个指针 `tail`,`p`,`q`，紧紧相邻，不断前进，每次将`p.next`指向`tail`，将`q.next`指向`p`。


### 解法1 迭代

{% if book.java %}
{% codesnippet "./code/reverse-linked-list-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法2 递归

{% if book.java %}
{% codesnippet "./code/reverse-linked-list-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
