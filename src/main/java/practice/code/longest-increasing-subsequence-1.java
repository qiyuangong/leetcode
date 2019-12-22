// Longest Increasing Subsequence
// 时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // f[i]表示以i结尾的最长递增子序列的长度
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        int global = 1;
        for (int j = 1; j < nums.length; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            global = Math.max(global, f[j]);
        }
        return global;
    }
}