// Convert Sorted Array to Binary Search Tree
// 二分法，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public TreeNode sortedArrayToBST (int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private static TreeNode sortedArrayToBST (int[] nums, int begin, int end) {
        int length = end - begin;
        if (length < 1) return null;  // 终止条件

        // 三方合并
        int mid = begin + length / 2;
        TreeNode root = new TreeNode (nums[mid]);
        root.left = sortedArrayToBST(nums, begin, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}