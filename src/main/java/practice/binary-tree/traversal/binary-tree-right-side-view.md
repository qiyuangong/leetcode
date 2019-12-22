## Binary Tree Right Side View


### 描述

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example, given the following binary tree,

```
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

You should return `[1, 3, 4]`.


### 分析

层次遍历。


### 代码

{% if book.java %}
```java
// Binary Tree Right Side View
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
            result.add(level.get(level.size()-1));
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
