// Minimum Depth of Binary Tree
// 迭代版，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        int result = Integer.MAX_VALUE;
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));

        while (!s.empty()) {
            final Pair p = s.pop();
            TreeNode node = p.node;
            int depth = p.depth;
            
            if (node.left == null && node.right == null)
                result = Math.min(result, depth);

            if (node.left != null && result > depth) // 深度控制，剪枝
                s.push(new Pair(node.left, depth + 1));

            if (node.right != null && result > depth) // 深度控制，剪枝
                s.push(new Pair(node.right, depth + 1));
        }

        return result;
    }
    
    static class Pair {
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}