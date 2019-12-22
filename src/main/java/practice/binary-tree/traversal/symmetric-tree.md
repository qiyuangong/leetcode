## Symmetric Tree


### 描述

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

Note:
Bonus points if you could solve it both recursively and iteratively.


### 分析

无


### 递归版

{% codesnippet "./code/symmetric-tree-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% if book.java %}
```java
// Symmetric Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isSymmetric (TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);

        while (!s.isEmpty()) {
            TreeNode p = s.pop ();
            TreeNode q = s.pop ();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            s.push(p.left);
            s.push(q.right);

            s.push(p.right);
            s.push(q.left);
        }

        return true;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Symmetric Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    bool isSymmetric (TreeNode* root) {
        if (!root) return true;

        stack<TreeNode*> s;
        s.push(root->left);
        s.push(root->right);

        while (!s.empty ()) {
            auto p = s.top (); s.pop();
            auto q = s.top (); s.pop();

            if (!p && !q) continue;
            if (!p || !q) return false;
            if (p->val != q->val) return false;

            s.push(p->left);
            s.push(q->right);

            s.push(p->right);
            s.push(q->left);
        }

        return true;
    }
};
```
{% endif %}


### 相关题目


* [Same Tree](same-tree.md)
