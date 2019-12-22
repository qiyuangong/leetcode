// House Robber
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
        }
        return f[nums.length - 1];
    }
}