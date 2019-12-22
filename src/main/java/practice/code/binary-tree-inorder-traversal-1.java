// Binary Tree Inorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.empty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }
}