// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int maxSubArray(const vector<int>& nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            maxLocal = max(nums[i], nums[i] + maxLocal);
            global = max(global, maxLocal);
        }
        return global;
    }
};