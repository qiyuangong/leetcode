// Unique Binary Search Trees II
// 时间复杂度TODO，空间复杂度TODO
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }
    private static List<TreeNode > generate(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();
        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> leftSubs = generate(start, k - 1);
            List<TreeNode> rightSubs = generate(k + 1, end);
            for (TreeNode i : leftSubs) {
                for (TreeNode j : rightSubs) {
                    TreeNode node = new TreeNode(k);
                    node.left = i;
                    node.right = j;
                    subTree.add(node);
                }
            }
        }
        return subTree;
    }
}