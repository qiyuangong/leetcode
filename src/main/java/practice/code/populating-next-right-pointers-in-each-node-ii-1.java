// Populating Next Right Pointers in Each Node II
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode dummy = new TreeLinkNode(-1);
        for (TreeLinkNode curr = root, prev = dummy;
                curr != null; curr = curr.next) {
            if (curr.left != null){
                prev.next = curr.left;
                prev = prev.next;
            }
            if (curr.right != null){
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
    }
}