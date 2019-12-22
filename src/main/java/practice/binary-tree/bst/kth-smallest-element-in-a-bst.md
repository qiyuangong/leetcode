## Kth Smallest Element in a BST


### 描述

Given a binary search tree, write a function `kthSmallest` to find the kth smallest element in it.

**Note**: 

You may assume `k` is always valid, `1 ≤ k ≤` BST's total elements.

**Follow up**:

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

**Hint**:

* Try to utilize the property of a BST.
* What if you could modify the BST node's structure?
* The optimal runtime complexity is O(height of BST).


### 分析

最简单的办法，中序遍历，即可以得到递增序列，从而可以找到第k大的元素。时间复杂度`O(k)`。

如果能够修改节点的数据结构`TreeNode`，可以增加一个字段`leftCnt`，表示左子树的节点个数。设当前节点为`root`，

* 若 `k == root.leftCnt+1`, 则返回root
* 若 `k > node.leftCnt`, 则 `k -= root.leftCnt+1`, `root=root.right`
* 否则，`node = node.left`

算法复杂度为`O(height of BST)`。


### 解法1

{% if book.java %}
{% codesnippet "./code/kth-smallest-element-in-a-bst."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
