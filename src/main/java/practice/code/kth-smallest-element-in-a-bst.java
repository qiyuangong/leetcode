// Kth Smallest Element in a BST
// Time Complexity: O(k), Space Complexity: O(h)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.empty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                --k;
                if (k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }
}