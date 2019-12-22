// Binary Tree Preorder Traversal
// Morris先序遍历，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        TreeNode *cur = root, *prev = nullptr;

        while (cur != nullptr) {
            if (cur->left == nullptr) {
                result.push_back(cur->val);
                prev = cur; /* cur刚刚被访问过 */
                cur = cur->right;
            } else {
                /* 查找前驱 */
                TreeNode *node = cur->left;
                while (node->right != nullptr && node->right != cur)
                    node = node->right;

                if (node->right == nullptr) { /* 还没线索化，则建立线索 */
                    result.push_back(cur->val); /* 仅这一行的位置与中序不同 */
                    node->right = cur;
                    prev = cur; /* cur刚刚被访问过 */
                    cur = cur->left;
                } else {    /* 已经线索化，则删除线索  */
                    node->right = nullptr;
                    /* prev = cur; 不能有这句，cur已经被访问 */
                    cur = cur->right;
                }
            }
        }
        return result;
    }
};