// Recover Binary Search Tree
// Morris中序遍历，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] broken = new TreeNode[2];
        TreeNode prev = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                detect(broken, prev, cur);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;

                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) {
                    node.right = cur;
                    //prev = cur; 不能有这句！因为cur还没有被访问
                    cur = cur.left;
                } else {
                    detect(broken, prev, cur);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        // swap
        int tmp = broken[0].val;
        broken[0].val = broken[1].val;
        broken[1].val = tmp;
    }

    void detect(TreeNode[] broken, TreeNode prev,
                TreeNode current) {
        if (prev != null && prev.val > current.val) {
            if (broken[0] == null) {
                broken[0] = prev;
            } //不能用else，例如 {0,1}，会导致最后 swap时second为nullptr，
            //会 Runtime Error
            broken[1] = current;
        }
    }
}