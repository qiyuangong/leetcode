// Longest Increasing Subsequence
// 时间复杂度O(nlogn)，空间复杂度O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.empty()) return 0;
        // f[i]表示以i结尾的最长递增子序列的长度
        vector<int> f(nums.size(), 1);
        int global = 1;
        for (int j = 1; j < nums.size(); ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    f[j] = max(f[j], f[i] + 1);
                }
            }
            global = max(global, f[j]);
        }
        return global;
    }
};