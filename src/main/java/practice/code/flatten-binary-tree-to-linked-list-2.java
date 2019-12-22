// Flatten Binary Tree to Linked List
// 递归版2
// @author 王顺达(http://weibo.com/u/1234984145)
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    // 把root所代表树变成链表后，tail跟在该链表后面
    private static TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) return tail;

        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }
}