## Remove Nth Node From End of List


### 描述

Given a linked list, remove the `n`-th node from the end of list and return its head.

For example, Given linked list: `1->2->3->4->5`, and `n` = 2.

After removing the second node from the end, the linked list becomes `1->2->3->5`.

Note:

*  Given `n` will always be valid.
*  Try to do this in one pass.


### 分析

设两个指针`p`,`q`，让`q`先走`n`步，然后`p`和`q`一起走，直到`q`走到尾节点，删除`p->next`即可。


### 代码

{% codesnippet "./code/remove-nth-node-from-end-of-list."+book.suffix, language=book.suffix %}{% endcodesnippet %}
