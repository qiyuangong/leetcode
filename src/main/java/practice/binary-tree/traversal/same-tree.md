## Same Tree


### 描述

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


### 分析

无


### 递归版

{% codesnippet "./code/same-tree-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% if book.java %}
```java
// Same Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s = new Stack<>();
        s.push(p);
        s.push(q);

        while(!s.empty()) {
            p = s.pop();
            q = s.pop();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            s.push(p.left);
            s.push(q.left);

            s.push(p.right);
            s.push(q.right);
        }
        return true;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Same Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q) {
        stack<TreeNode*> s;
        s.push(p);
        s.push(q);

        while(!s.empty()) {
            p = s.top(); s.pop();
            q = s.top(); s.pop();

            if (!p && !q) continue;
            if (!p || !q) return false;
            if (p->val != q->val) return false;

            s.push(p->left);
            s.push(q->left);

            s.push(p->right);
            s.push(q->right);
        }
        return true;
    }
};
```
{% endif %}


### 相关题目


* [Symmetric Tree](symmetric-tree.md)
