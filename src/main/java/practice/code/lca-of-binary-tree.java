// Lowest Common Ancestor of a Binary Tree
// Time complexity: O(n), Space complexity: O(h)
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if root is null or found p or q
        if (root == null || root == p || root == q) return root;
        // find p or q in the left subtree
        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        // find p or q in the right subtree
        final TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else return left == null ? right : left;
    }
}