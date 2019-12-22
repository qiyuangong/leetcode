本章主要讲树相关的算法。

LeetCode 上二叉树的节点定义如下：

{% if book.cpp %}
```cpp
// 树的节点
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) { }
};
```
{% endif %}


{% if book.java %}
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```
{% endif %}
