## Binary Tree Preorder Traversal


### 描述

Given a binary tree, return the **preorder** traversal of its nodes' values.

For example:
Given binary tree `{1,#,2,3}`,

```
 1
  \
   2
  /
 3
```

return `[1,2,3]`.

Note: Recursive solution is trivial, could you do it iteratively?


### 分析

用栈或者Morris遍历。


### 栈

{% if book.java %}
```java
// Binary Tree Preorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root != null) s.push(root);

        while (!s.isEmpty()) {
            final TreeNode p = s.pop();
            result.add(p.val);

            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Binary Tree Preorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        stack<const TreeNode *> s;
        if (root != nullptr) s.push(root);

        while (!s.empty()) {
            const TreeNode *p = s.top();
            s.pop();
            result.push_back(p->val);

            if (p->right != nullptr) s.push(p->right);
            if (p->left != nullptr) s.push(p->left);
        }
        return result;
    }
};
```
{% endif %}


### Morris先序遍历

{% codesnippet "./code/binary-tree-preorder-traversal-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Binary Tree Inorder Traversal](binary-tree-inorder-traversal.md)
* [Binary Tree Postorder Traversal](binary-tree-postorder-traversal.md)
* [Recover Binary Search Tree](recover-binary-search-tree.md)
