## Path Sum II


### 描述

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and `sum = 22`,

```
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
```

return

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```


### 分析

跟上一题相比，本题是求路径本身。且要求出所有结果，左子树求到了满意结果，不能return，要接着求右子树。

### 代码

{% if book.java %}
```java
// Path Sum II
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer>  cur = new ArrayList<>(); // 中间结果
        pathSum(root, sum, cur, result);
        return result;
    }
    private static void pathSum(TreeNode root, int gap, ArrayList<Integer> cur,
                                List<List<Integer>> result) {
        if (root == null) return;

        cur.add(root.val);

        if (root.left == null && root.right == null) { // leaf
            if (gap == root.val)
                result.add(new ArrayList<>(cur));
        }
        pathSum(root.left, gap - root.val, cur, result);
        pathSum(root.right, gap - root.val, cur, result);

        cur.remove(cur.size() - 1);
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Path Sum II
// 时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int> > result;
        vector<int> cur; // 中间结果
        pathSum(root, sum, cur, result);
        return result;
    }
private:
    void pathSum(TreeNode *root, int gap, vector<int> &cur,
            vector<vector<int> > &result) {
        if (root == nullptr) return;

        cur.push_back(root->val);

        if (root->left == nullptr && root->right == nullptr) { // leaf
            if (gap == root->val)
                result.push_back(cur);
        }
        pathSum(root->left, gap - root->val, cur, result);
        pathSum(root->right, gap - root->val, cur, result);

        cur.pop_back();
    }
};
```
{% endif %}


### 相关题目


* [Path Sum](path-sum.md)
