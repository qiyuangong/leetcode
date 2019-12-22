// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int maxSubArray(int[] nums) {
        return mcss(nums, 0, nums.length);
    }
    // 思路5，求最大连续子序列和
    private static int mcss(int[] nums, int begin, int end) {
        final int n = end - begin;
        int[] sum = new int[n + 1];  // 前n项和

        int result = Integer.MIN_VALUE;
        int cur_min = sum[0];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[begin  + i - 1];
        }
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, sum[i] - cur_min);
            cur_min = Math.min(cur_min, sum[i]);
        }
        return result;
    }
}