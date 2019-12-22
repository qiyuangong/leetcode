// Recover Binary Search Tree
// 中序遍历,递归
// 时间复杂度O(n)，空间复杂度O(logn)
// 本代码仅仅是为了帮助理解题目
class Solution {
public:
    void recoverTree(TreeNode *root) {
        inOrder( root);
        swap(p1->val, p2->val);
    }
private:
    void inOrder(TreeNode *root) {
        if ( root ==  nullptr ) return;
        if ( root->left != nullptr ) inOrder(root->left);

        if ( prev != nullptr && root->val < prev->val ) {
            if ( p1 == nullptr) {
                p1 = prev;
                p2 = root;
            } else {
                p2 = root;
            }
        }
        prev = root;
        if ( root->right != nullptr ) inOrder(root->right);
    }
    TreeNode *p1 = nullptr;
    TreeNode *p2 = nullptr;
    TreeNode *prev = nullptr;
};