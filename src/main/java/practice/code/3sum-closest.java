// 3Sum Closest
// 先排序，然后左右夹逼
// Time Complexity: O(n^2), Space Complexity: O(1)
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    result = sum;
                    minGap = gap;
                }

                if (sum < target) ++j;
                else              --k;
            }
        }
        return result;
    }
}

