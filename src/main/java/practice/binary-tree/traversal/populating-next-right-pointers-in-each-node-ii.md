## Populating Next Right Pointers in Each Node II


### 描述

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note: You may only use constant extra space.

For example,
Given the following binary tree,

```
         1
       /  \
      2    3
     / \    \
    4   5    7
```

After calling your function, the tree should look like:

```
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
```


### 分析

要处理一个节点，可能需要最右边的兄弟节点，首先想到用广搜。但广搜不是常数空间的，本题要求常数空间。

注意，这题的代码原封不动，也可以解决 Populating Next Right Pointers in Each Node I.


### 递归版

{% codesnippet "./code/populating-next-right-pointers-in-each-node-ii-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% codesnippet "./code/populating-next-right-pointers-in-each-node-ii-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Populating Next Right Pointers in Each Node](populating-next-right-pointers-in-each-node.md)
