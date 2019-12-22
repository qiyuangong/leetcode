// Find Minimum in Rotated Sorted Array II
// 时间复杂度O(logn)，最坏 O(n)，空间复杂度O(1)
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                --right;
            }
        }
        return nums[left];
    }
}