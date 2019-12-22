// Same Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s = new Stack<>();
        s.push(p);
        s.push(q);

        while(!s.empty()) {
            p = s.pop();
            q = s.pop();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            s.push(p.left);
            s.push(q.left);

            s.push(p.right);
            s.push(q.right);
        }
        return true;
    }
}