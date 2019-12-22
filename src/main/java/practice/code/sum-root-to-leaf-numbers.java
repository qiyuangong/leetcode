// Sum root to leaf numbers
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private static int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;

        return dfs(root.left, sum * 10 + root.val) +
                dfs(root.right, sum * 10 + root.val);
    }
}