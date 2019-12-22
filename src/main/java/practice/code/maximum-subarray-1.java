// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxLocal = Math.max(nums[i], nums[i] + maxLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
}