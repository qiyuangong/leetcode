// Minimum Depth of Binary Tree
// 递归版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public int minDepth(TreeNode root) {
        return minDepth(root, false);
    }
    private static int minDepth(TreeNode root, boolean hasbrother) {
        if (root == null) return hasbrother ? Integer.MAX_VALUE : 0;

        return 1 + Math.min(minDepth(root.left, root.right != null),
                minDepth(root.right, root.left != null));
    }
}