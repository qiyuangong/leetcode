## Binary Tree Level Order Traversal


### 描述

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `{3,9,20,#,#,15,7}`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```


### 分析

无


### 递归版

{% if book.java %}
```java
// Binary Tree Level Order Traversal
// 递归版，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        return result;
    }

    void traverse(TreeNode root, int level,
                  List<List<Integer>> result) {
        if (root == null) return;

        if (level > result.size())
            result.add(new ArrayList<>());

        result.get(level-1).add(root.val);
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Binary Tree Level Order Traversal
// 递归版，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> result;
        traverse(root, 1, result);
        return result;
    }

    void traverse(TreeNode *root, size_t level, vector<vector<int>> &result) {
        if (!root) return;

        if (level > result.size())
            result.push_back(vector<int>());

        result[level-1].push_back(root->val);
        traverse(root->left, level+1, result);
        traverse(root->right, level+1, result);
    }
};
```
{% endif %}



### 迭代版

{% if book.java %}
```java
// Binary Tree Level Order Traversal
// 迭代版，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if(root == null) {
            return result;
        } else {
            current.offer(root);
        }

        while (!current.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>(); // elments in one level
            while (!current.isEmpty()) {
                TreeNode node = current.poll();
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(level);
            // swap
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Binary Tree Level Order Traversal
// 迭代版，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int> > result;
        queue<TreeNode*> current, next;
        
        if(root == nullptr) {
            return result;
        } else {
            current.push(root);
        }

        while (!current.empty()) {
            vector<int> level; // elments in one level
            while (!current.empty()) {
                TreeNode* node = current.front();
                current.pop();
                level.push_back(node->val);
                if (node->left != nullptr) next.push(node->left);
                if (node->right != nullptr) next.push(node->right);
            }
            result.push_back(level);
            swap(next, current);
        }
        return result;
    }
};
```
{% endif %}


### 相关题目


* [Binary Tree Level Order Traversal II](binary-tree-tevel-order-traversal-ii.md)
* [Binary Tree Zigzag Level Order Traversal](binary-tree-zigzag-level-order-traversal.md)
