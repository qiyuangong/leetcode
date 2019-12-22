## Unique Binary Search Trees II


### 描述

Given `n`, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given `n = 3`, your program should return all 5 unique BST's shown below.

```
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```


### 分析

见前面一题。


### 代码

{% if book.java %}
```java
// Unique Binary Search Trees II
// 时间复杂度TODO，空间复杂度TODO
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }
    private static List<TreeNode > generate(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();
        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> leftSubs = generate(start, k - 1);
            List<TreeNode> rightSubs = generate(k + 1, end);
            for (TreeNode i : leftSubs) {
                for (TreeNode j : rightSubs) {
                    TreeNode node = new TreeNode(k);
                    node.left = i;
                    node.right = j;
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Unique Binary Search Trees II
// 时间复杂度TODO，空间复杂度TODO
class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        if (n == 0) return vector<TreeNode*>();
        return generate(1, n);
    }
private:
    vector<TreeNode *> generate(int start, int end) {
        vector<TreeNode*> subTree;
        if (start > end) {
            subTree.push_back(nullptr);
            return subTree;
        }
        for (int k = start; k <= end; k++) {
            vector<TreeNode*> leftSubs = generate(start, k - 1);
            vector<TreeNode*> rightSubs = generate(k + 1, end);
            for (auto i : leftSubs) {
                for (auto j : rightSubs) {
                    TreeNode *node = new TreeNode(k);
                    node->left = i;
                    node->right = j;
                    subTree.push_back(node);
                }
            }
        }
        return subTree;
    }
};
```
{% endif %}


### 相关题目


* [Unique Binary Search Trees](unique-binary-search-trees.md)
