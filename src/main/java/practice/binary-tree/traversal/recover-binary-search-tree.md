## Recover Binary Search Tree


### 描述

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note: A solution using `O(n)` space is pretty straight forward. Could you devise a constant space solution?


### 分析

`O(logn)`空间的解法是，中序递归遍历，用两个指针存放在遍历过程中碰到的两处逆向的位置。

本题要求`O(1)`空间，只能用Morris中序遍历。


### 中序遍历，递归方式

{% codesnippet "./code/recover-binary-search-tree-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### Morris中序遍历

{% if book.java %}
{% codesnippet "./code/recover-binary-search-tree-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Recover Binary Search Tree
// Morris中序遍历，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    void recoverTree(TreeNode* root) {
        pair<TreeNode*, TreeNode*> broken;
        TreeNode* prev = nullptr;
        TreeNode* cur = root;

        while (cur != nullptr) {
            if (cur->left == nullptr) {
                detect(broken, prev, cur);
                prev = cur;
                cur = cur->right;
            } else {
                auto node = cur->left;

                while (node->right != nullptr && node->right != cur)
                    node = node->right;

                if (node->right == nullptr) {
                    node->right = cur;
                    //prev = cur; 不能有这句！因为cur还没有被访问
                    cur = cur->left;
                } else {
                    detect(broken, prev, cur);
                    node->right = nullptr;
                    prev = cur;
                    cur = cur->right;
                }
            }
        }

        swap(broken.first->val, broken.second->val);
    }

    void detect(pair<TreeNode*, TreeNode*>& broken, TreeNode* prev,
            TreeNode* current) {
        if (prev != nullptr && prev->val > current->val) {
            if (broken.first == nullptr) {
                broken.first = prev;
            } //不能用else，例如 {0,1}，会导致最后 swap时second为nullptr，
              //会 Runtime Error
            broken.second = current;
        }
    }
};
```
{% endif %}


### 相关题目


* [Binary Tree Inorder Traversal](binary-tree-inorder-traversal.md)
