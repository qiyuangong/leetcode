// Balanced Binary Tree
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isBalanced (TreeNode root) {
        return balancedHeight (root) >= 0;
    }

    /**
     * Returns the height of `root` if `root` is a balanced tree,
     * otherwise, returns `-1`.
     */
    private static int balancedHeight (TreeNode root) {
        if (root == null) return 0;  // 终止条件

        int left = balancedHeight (root.left);
        int right = balancedHeight (root.right);

        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;  // 剪枝

        return Math.max(left, right) + 1; // 三方合并
    }
}