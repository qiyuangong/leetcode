## Odd Even Linked List


### 描述

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in `O(1)` space complexity and `O(n)` time complexity.

**Example**:

Given `1->2->3->4->5->NULL`,

return `1->3->5->2->4->NULL`.

**Note**:

1. The relative order inside both the even and odd groups should remain as it was in the input. 
1. The first node is considered odd, the second node even and so on ...


### 分析

创建两个新的空链表，遍历原始链表，把奇数位置的节点添加到第一个小链表，把偶数位置的节点添加到第二个小链表。


### 代码

{% if book.java %}
{% codesnippet "./code/odd-even-linked-list."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
