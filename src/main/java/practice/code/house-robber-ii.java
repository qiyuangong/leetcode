// House Robber II
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(nums, 0, nums.length - 1),
                rob1(nums, 1, nums.length));
    }

    private static int rob1(int[] nums, int begin, int end) {
        if (nums == null || begin >= end) return 0;
        if ((end - begin) == 1) return nums[begin];

        int even = nums[begin];
        int odd = Math.max(nums[begin], nums[begin + 1]);

        for (int i = begin + 2; i < end; ++i) {
            if ((i-begin) % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(even, odd);
    }
}