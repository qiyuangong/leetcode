// Rotate Array
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - k);
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length);
    }
    private static void reverse(int[] nums, int begin, int end) {
        int left = begin;
        int right = end - 1;
        while (left < right) {
            // swap
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }
}