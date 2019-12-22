// Maximum Gap
// Counting Sort
// Time Complexity: O(n), Space Complexity: O(max-min)
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        countingSort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }
    private static void countingSort(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i : nums) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        final int[] buckets = new int[maxValue - minValue + 1];

        for (int i : nums) {
            buckets[i - minValue]++;
        }

        for (int i = 0, index = 0; i < buckets.length; ++i) {
            Arrays.fill(nums, index, index + buckets[i], i + minValue);
            index += buckets[i];
        }
    }
}