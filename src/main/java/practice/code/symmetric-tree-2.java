// Symmetric Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isSymmetric (TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);

        while (!s.isEmpty()) {
            TreeNode p = s.pop ();
            TreeNode q = s.pop ();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            s.push(p.left);
            s.push(q.right);

            s.push(p.right);
            s.push(q.left);
        }

        return true;
    }
}