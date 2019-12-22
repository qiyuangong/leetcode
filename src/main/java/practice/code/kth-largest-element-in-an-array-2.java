// Kth Largest Element in an Array
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    private static int findKthLargest(int[] nums, int begin, int end, int k) {
        if (begin + 1 == end && k == 1) return nums[0];

        final int pos = partition(nums, begin, end - 1);
        final int len = pos - begin;

        if (len == k) {
            return nums[pos-1];
        } else if (len < k) {
            return findKthLargest(nums, pos, end, k - len);
        } else {
            return findKthLargest(nums, begin, pos, k);
        }
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            final int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }
    private static int partition(int[] nums, int i, int j) {
        final int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) --j;
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot) ++i;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}