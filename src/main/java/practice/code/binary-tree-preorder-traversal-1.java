// Binary Tree Preorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root != null) s.push(root);

        while (!s.isEmpty()) {
            final TreeNode p = s.pop();
            result.add(p.val);

            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);
        }
        return result;
    }
}