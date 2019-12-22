// Invert Binary Tree
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}