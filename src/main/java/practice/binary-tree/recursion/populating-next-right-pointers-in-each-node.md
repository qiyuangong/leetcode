## Populating Next Right Pointers in Each Node


### 描述

Given a binary tree

```cpp
struct TreeLinkNode {
   int val;
   TreeLinkNode *left, *right, *next;
   TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

Note:

* You may only use constant extra space.
* You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).


For example,

```
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
```

After calling your function, the tree should look like:

```
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
```


### 分析

无

### 代码


{% codesnippet "./code/populating-next-right-pointers-in-each-node."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Populating Next Right Pointers in Each Node II](populating-next-right-pointers-in-each-node-ii.md)
