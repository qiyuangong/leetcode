// Flatten Binary Tree to Linked List
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.empty()) {
            TreeNode p = s.pop();

            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);

            p.left = null;
            if (!s.empty()) p.right = s.peek();
        }
    }
}