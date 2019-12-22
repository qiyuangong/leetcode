// Symmetric Tree
// 递归版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;   // 终止条件
        if (p == null || q == null) return false;  // 终止条件
        return p.val == q.val      // 三方合并
                && isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left);
    }
}