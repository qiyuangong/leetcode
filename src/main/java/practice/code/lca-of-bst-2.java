// LCA of BST
// Time Complexity: O(h), Space Complexity: O(1)
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (Math.max(p.val, q.val) < root.val) {
                root = root.left;
            } else if (Math.min(p.val, q.val) > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}