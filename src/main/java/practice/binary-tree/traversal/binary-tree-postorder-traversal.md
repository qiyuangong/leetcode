## Binary Tree Postorder Traversal


### 描述

Given a binary tree, return the **postorder** traversal of its nodes' values.

For example:
Given binary tree `{1,#,2,3}`,

```
 1
  \
   2
  /
 3
```

return `[3,2,1]`.

Note: Recursive solution is trivial, could you do it iteratively?


### 分析

用栈或者Morris遍历。


### 栈

{% if book.java %}
```java
// Binary Tree Postorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        /* p，正在访问的结点，q，刚刚访问过的结点*/
        TreeNode p = root;
        TreeNode q = null;

        do {
            while (p != null) { /* 往左下走*/
                s.push(p);
                p = p.left;
            }
            q = null;
            while (!s.empty()) {
                p = s.pop();
                /* 右孩子不存在或已被访问，访问之*/
                if (p.right == q) {
                    result.add(p.val);
                    q = p; /* 保存刚访问过的结点*/
                } else {
                    /* 当前结点不能访问，需第二次进栈*/
                    s.push(p);
                    /* 先处理右子树*/
                    p = p.right;
                    break;
                }
            }
        } while (!s.empty());

        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Binary Tree Postorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> result;
        stack<const TreeNode *> s;
        /* p，正在访问的结点，q，刚刚访问过的结点*/
        const TreeNode *p = root, *q = nullptr;

        do {
            while (p != nullptr) { /* 往左下走*/
                s.push(p);
                p = p->left;
            }
            q = nullptr;
            while (!s.empty()) {
                p = s.top();
                s.pop();
                /* 右孩子不存在或已被访问，访问之*/
                if (p->right == q) {
                    result.push_back(p->val);
                    q = p; /* 保存刚访问过的结点*/
                } else {
                    /* 当前结点不能访问，需第二次进栈*/
                    s.push(p);
                    /* 先处理右子树*/
                    p = p->right;
                    break;
                }
            }
        } while (!s.empty());

        return result;
    }
};
```
{% endif %}


### Morris后序遍历

{% codesnippet "./code/binary-tree-postorder-traversal-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Binary Tree Preorder Traversal](binary-tree-preorder-traversal.md)
* [Binary Tree Inorder Traversal](binary-tree-inorder-traversal.md)
* [Recover Binary Search Tree](recover-binary-search-tree.md)
