// Binary Search Tree Iterator
public class BSTIterator {
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        final TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode p = node.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

        }
        return node.val;
    }
    private Stack<TreeNode> stack;
}