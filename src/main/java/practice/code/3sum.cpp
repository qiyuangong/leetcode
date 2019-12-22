// 3Sum
// 先排序，然后左右夹逼，注意跳过重复的数
// Time Complexity: O(n^2)，Space Complexity: O(1)
class Solution {
    public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        if (nums.size() < 3) return result;
        sort(nums.begin(), nums.end());
        const int target = 0;
        
        auto last = nums.end();
        for (auto i = nums.begin(); i < last-2; ++i) {
            if (i > nums.begin() && *i == *(i-1)) continue;
            auto j = i+1;
            auto k = last-1;
            while (j < k) {
                if (*i + *j + *k < target) {
                    ++j;
                    while(*j == *(j - 1) && j < k) ++j;
                } else if (*i + *j + *k > target) {
                    --k;
                    while(*k == *(k + 1) && j < k) --k;
                } else {
                    result.push_back({ *i, *j, *k });
                    ++j;
                    --k;
                    while(*j == *(j - 1) && j < k) ++j;
                    while(*k == *(k + 1) && j < k) --k;
                }
            }
        }
        return result;
    }
};