## Convert Sorted List to Binary Search Tree


### 描述

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


### 分析

这题与上一题类似，但是单链表不能随机访问，而自顶向下的二分法必须需要RandomAccessIterator，因此前面的方法不适用本题。

存在一种自底向上(bottom-up)的方法，见 <http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html>


### 分治法，自顶向下

分治法，类似于 Convert Sorted Array to Binary Search Tree，自顶向下，复杂度 `O(nlogn)`。

{% codesnippet "./code/convert-sorted-list-to-binary-search-tree-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 自底向上

{% codesnippet "./code/convert-sorted-list-to-binary-search-tree-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Convert Sorted Array to Binary Search Tree](convert-sorted-array-to-binary-search-tree.md)
