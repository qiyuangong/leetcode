// Binary Tree Zigzag Level Order Traversal
// 广度优先遍历，用一个bool记录是从左到右还是从右到左，每一层结束就翻转一下。
// 迭代版，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        boolean left_to_right = true;

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
                if (node.left != null) next.offer(node.left);
                if (node.right != null) next.offer(node.right);
            }
            if (!left_to_right) Collections.reverse(level);
            result.add(level);
            left_to_right = !left_to_right;
            // swap
            Queue<TreeNode> tmp = current;
            current = next;
            next = tmp;
        }
        return result;
    }
}