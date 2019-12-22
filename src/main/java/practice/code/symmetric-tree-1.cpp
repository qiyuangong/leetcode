// Symmetric Tree
// 递归版，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if (root == nullptr) return true;
        return isSymmetric(root->left, root->right);
    }
    bool isSymmetric(TreeNode *p, TreeNode *q) {
        if (p == nullptr && q == nullptr) return true;   // 终止条件
        if (p == nullptr || q == nullptr) return false;  // 终止条件
        return p->val == q->val      // 三方合并
                && isSymmetric(p->left, q->right)
                && isSymmetric(p->right, q->left);
    }
};