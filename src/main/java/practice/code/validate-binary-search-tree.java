// Validate Binary Search Tree
// 时间复杂度O(n)，空间复杂度O(\logn)
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, INT_MIN, INT_MAX);
    }

    bool isValidBST(TreeNode* root, int lower, int upper) {
        if (root == nullptr) return true;

        return root.val > lower && root.val < upper
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}