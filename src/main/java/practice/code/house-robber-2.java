// House Robber
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int even = nums[0];
        int odd = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(even, odd);
    }
}