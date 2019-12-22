## Reverse Nodes in k-Group


### 描述

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of `k` then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: `1->2->3->4->5`

For `k = 2`, you should return: `2->1->4->3->5`

For `k = 3`, you should return: `3->2->1->4->5`


### 分析

无


### 递归版

{% codesnippet "./code/reverse-nodes-in-k-group-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% codesnippet "./code/reverse-nodes-in-k-group-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Swap Nodes in Pairs](swap-nodes-in-pairs.md)
