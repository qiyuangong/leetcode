// Recover Binary Search Tree
// 中序遍历,递归
// 时间复杂度O(n)，空间复杂度O(logn)
// 本代码仅仅是为了帮助理解题目
public class Solution {
    private TreeNode p1 = null;
    private TreeNode p2 = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inOrder( root);
        // swap
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if ( root ==  null ) return;
        if ( root.left != null ) inOrder(root.left);

        if ( prev != null && root.val < prev.val ) {
            if ( p1 == null) {
                p1 = prev;
                p2 = root;
            } else {
                p2 = root;
            }
        }
        prev = root;
        if ( root.right != null ) inOrder(root.right);
    }
}