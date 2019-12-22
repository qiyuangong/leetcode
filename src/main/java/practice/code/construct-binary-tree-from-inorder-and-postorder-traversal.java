// Construct Binary Tree from Inorder and Postorder Traversal
// 递归，时间复杂度O(n)，空间复杂度O(\logn)
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length,
                postorder, 0, postorder.length);
    }

    TreeNode buildTree(int[] inorder, int begin1, int end1,
                       int[] postorder, int begin2, int end2) {
        if (begin1 ==end1) return null;
        if (begin2 ==end2) return null;

        int val = postorder[end2 - 1];
        TreeNode root = new TreeNode(val);

        int in_root_pos = find(inorder, begin1, end1, val);
        int left_size = in_root_pos - begin1;
        int post_left_last = begin2 + left_size;

        root.left = buildTree(inorder, begin1, in_root_pos, 
                postorder, begin2, post_left_last);
        root.right = buildTree(inorder, in_root_pos + 1, end1, 
                postorder, post_left_last, end2 - 1);

        return root;
    }
    private static int find(int[] array, int begin, int end, int val) {
        for (int i = begin; i < end; ++i) {
            if (array[i] == val) return i;
        }
        return -1;
    }
}