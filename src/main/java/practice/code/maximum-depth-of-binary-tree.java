// Maximum Depth of Binary Tree
// 时间复杂度O(n)，空间复杂度O(logn)
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}