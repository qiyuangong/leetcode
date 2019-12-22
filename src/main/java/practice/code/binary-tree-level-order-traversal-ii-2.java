// Binary Tree Level Order Traversal II
// 迭代版，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if(root == null) {
            return result;
        } else {
            current.offer(root);
        }

        while (!current.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>(); // elments in one level
            while (!current.isEmpty()) {
                TreeNode node = current.poll();
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(level);
            // swap
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
        Collections.reverse(result);
        return result;
    }
}