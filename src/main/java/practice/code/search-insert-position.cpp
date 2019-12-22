// Search Insert Position
// 重新实现 lower_bound
// 时间复杂度O(logn)，空间复杂度O(1)
class Solution {
public:
    int searchInsert(const vector<int>& nums, int target) {
        return lower_bound(nums, 0, nums.size(), target);
    }

    int lower_bound (const vector<int>& A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A[mid]) first = ++mid;
            else                 last = mid;
        }

        return first;
    }
};