// Maximum Depth of Binary Tree
// 时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    int maxDepth(TreeNode *root) {
        if (root == nullptr) return 0;

        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};