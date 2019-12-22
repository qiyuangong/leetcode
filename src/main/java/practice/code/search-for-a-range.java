// Search for a Range
// 重新实现 lower_bound 和 upper_bound
// 时间复杂度O(logn)，空间复杂度O(1)
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lower_bound(nums, 0, nums.length, target);
        int upper = upper_bound(nums, 0, nums.length, target);

        if (lower == nums.length || nums[lower] != target)
            return new int[]{-1, -1};
        else
            return new int[]{lower, upper-1};
    }

    int lower_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A[mid]) first = ++mid;
            else                 last = mid;
        }

        return first;
    }

    int upper_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target >= A[mid]) first = ++mid;  // 与 lower_bound 仅此不同
            else                  last = mid;
        }

        return first;
    }
}