// Binary Tree Maximum Path Sum
// 时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        dfs(root);
        return max_sum;
    }
    private int max_sum;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if (l > 0) sum += l;
        if (r > 0) sum += r;
        max_sum = Math.max(max_sum, sum);
        return Math.max(r, l) > 0 ? Math.max(r, l) + root.val : root.val;
    }
}