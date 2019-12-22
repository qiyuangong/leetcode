// Maximum Gap
// Bucket Sort
// Time Complexity: O(n+k), Space Complexity: O(n+k)
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        bucketSort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }

    private static void bucketSort(int[] nums) {
        if (nums.length < 2) return;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i : nums) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        final int bucketSize = (maxValue - minValue) / nums.length + 1;
        final int bucketCount = (maxValue - minValue) / bucketSize + 1;
        final ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int x : nums) {
            final int index = (x - minValue) / bucketSize;
            buckets[index].add(x);
        }

        for (final ArrayList<Integer> list : buckets) {
            Collections.sort(list);
        }

        int i = 0;
        for (final ArrayList<Integer> list : buckets) {
            for (int x : list) {
                nums[i++] = x;
            }
        }
    }
}