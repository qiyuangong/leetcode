## Binary Tree Zigzag Level Order Traversal


### 描述

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:

Given binary tree `{3,9,20,#,#,15,7}`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its zigzag level order traversal as:

```
[
  [3],
  [20,9],
  [15,7]
]
```


### 分析

广度优先遍历，用一个bool记录是从左到右还是从右到左，每一层结束就翻转一下。


### 递归版

{% codesnippet "./code/binary-tree-zigzag-level-order-traversal-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% codesnippet "./code/binary-tree-zigzag-level-order-traversal-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Binary Tree Level Order Traversal](binary-tree-tevel-order-traversal.md)
* [Binary Tree Level Order Traversal II](binary-tree-tevel-order-traversal-ii.md)
