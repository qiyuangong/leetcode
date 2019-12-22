## Binary Tree Inorder Traversal


### 描述

Given a binary tree, return the **inorder** traversal of its nodes' values.

For example:

Given binary tree `{1,#,2,3}`,

```
 1
  \
   2
  /
 3
```

return `[1,3,2]`.

Note: Recursive solution is trivial, could you do it iteratively?


### 分析

用栈或者Morris遍历。


### 栈

{% if book.java %}
```java
// Binary Tree Inorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.empty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Binary Tree Inorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        stack<const TreeNode *> s;
        const TreeNode *p = root;

        while (!s.empty() || p != nullptr) {
            if (p != nullptr) {
                s.push(p);
                p = p->left;
            } else {
                p = s.top();
                s.pop();
                result.push_back(p->val);
                p = p->right;
            }
        }
        return result;
    }
};
```
{% endif %}


### Morris中序遍历

{% codesnippet "./code/binary-tree-inorder-traversal-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Binary Tree Preorder Traversal](binary-tree-preorder-traversal.md)
* [Binary Tree Postorder Traversal](binary-tree-postorder-traversal.md)
* [Recover Binary Search Tree](recover-binary-search-tree.md)
