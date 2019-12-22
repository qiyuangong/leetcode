## Palindrome Linked List


### 描述

Given a singly linked list, determine if it is a palindrome.

**Follow up**:

Could you do it in `O(n)` time and `O(1)` space?


### 分析

首先要寻找中点，原理是使用快慢指针，每次快指针走两步，慢指针走一步。同时还要用栈，每次慢指针走一步，都把值存入栈中。等快指针走完时，链表的前半段都存入栈中了。最后慢指针继续往前走，每次与栈顶元素进行比较。空间复杂度`O(n)`。

如何做到用`O(1)`空间呢？可以先找到中点，把后半段reverse一下，然后比较两个小链表。


### 代码

{% if book.java %}
{% codesnippet "./code/palindrome-linked-list."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}