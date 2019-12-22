// Flatten Binary Tree to Linked List
// 递归版1，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;  // 终止条件

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;

        // 三方合并，将左子树所形成的链表插入到root和root->right之间
        TreeNode p = root.left;
        while(p.right != null) p = p.right; //寻找左链表最后一个节点
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}