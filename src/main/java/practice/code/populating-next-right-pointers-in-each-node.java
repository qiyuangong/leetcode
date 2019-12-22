// Populating Next Right Pointers in Each Node
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }
    private static void connect(TreeLinkNode root, TreeLinkNode sibling) {
        if (root == null) return;
        else root.next = sibling;

        connect(root.left, root.right);
        if (sibling != null) connect(root.right, sibling.left);
        else connect(root.right, null);
    }
}