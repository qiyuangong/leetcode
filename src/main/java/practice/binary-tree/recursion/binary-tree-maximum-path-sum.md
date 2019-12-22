## Binary Tree Maximum Path Sum


### 描述

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.
For example:
Given the below binary tree,

```
  1
 / \
2   3
```

Return `6`.


### 分析

这题很难，路径可以从任意节点开始，到任意节点结束。

可以利用“最大连续子序列和”问题的思路，见这节[Maximum Subarray](maximum-subarray.md)。如果说Array只有一个方向的话，那么Binary Tree其实只是左、右两个方向而已，我们需要比较两个方向上的值。

不过，Array可以从头到尾遍历，那么Binary Tree怎么办呢，我们可以采用Binary Tree最常用的dfs来进行遍历。先算出左右子树的结果L和R，如果L大于0，那么对后续结果是有利的，我们加上L，如果R大于0，对后续结果也是有利的，继续加上R。


### 代码

{% codesnippet "./code/binary-tree-maximum-path-sum."+book.suffix, language=book.suffix %}{% endcodesnippet %}


注意，最后return的时候，只返回一个方向上的值，为什么？这是因为在递归中，只能向父节点返回，不可能存在L->root->R的路径，只可能是L->root或R->root。


### 相关题目

* [Maximum Subarray](maximum-subarray.md)
* [Maximum Product Subarray](maximum-product-subarray.md)
