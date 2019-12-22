## House Robber III


### 描述

All houses in this place **forms a binary tree**. It will automatically contact the police if two directly-linked houses were broken into on the same night.

**Example 1**:

```
     3
    / \
   2   3
    \   \ 
     3   1
```

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

**Example 2**:

```
     3
    / \
   4   5
  / \   \ 
 1   3   1
```

Maximum amount of money the thief can rob = 4 + 5 = 9.


### 分析

树形动规。设状态 `f(root)` 表示抢劫root为根节点的二叉树，root可抢也可能不抢，能得到的最大金钱，`g(root)`表示抢劫root为根节点的二叉树，但不抢root，能得到的最大金钱，则状态转移方程为

`f(root) = max{f(root.left) + f(root.right), g(root.left)+g(root.right) + root.val}`

`g(root) = f(root.left) + f(root.right)`


### 代码

{% if book.java %}
{% codesnippet "./code/house-robber-iii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
