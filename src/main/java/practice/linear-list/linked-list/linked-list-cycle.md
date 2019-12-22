## Linked List Cycle


### 描述

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


### 分析

最容易想到的方法是，用一个哈希表`unordered_map<int, bool> visited`，记录每个元素是否被访问过，一旦出现某个元素被重复访问，说明存在环。空间复杂度`O(n)`，时间复杂度`O(N)`。

最好的方法是时间复杂度`O(n)`，空间复杂度`O(1)`的。设置两个指针，一个快一个慢，快的指针每次走两步，慢的指针每次走一步，如果快指针和慢指针相遇，则说明有环。参考\myurl{ http://leetcode.com/2010/09/detecting-loop-in-singly-linked-list.html}


### 代码

{% codesnippet "./code/linked-list-cycle."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Linked List Cycle II](linked-list-cycle-ii.md)
