// Binary Tree Level Order Traversal
// 递归版，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 1, result);
        return result;
    }

    void traverse(TreeNode root, int level,
                  List<List<Integer>> result) {
        if (root == null) return;

        if (level > result.size())
            result.add(new ArrayList<>());

        result.get(level-1).add(root.val);
        traverse(root.left, level+1, result);
        traverse(root.right, level+1, result);
    }
}