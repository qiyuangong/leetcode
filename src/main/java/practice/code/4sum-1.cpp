// 4Sum
// 先排序，然后左右夹逼
// Time Complexity: O(n^3)，Space Complexity: O(1)
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        if (nums.size() < 4) return result;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size() - 3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.size() - 2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = nums.size() - 1;
                while (k < l) {
                    const int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        ++k;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                    } else if (sum > target) {
                        --l;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    } else {
                        result.push_back({nums[i], nums[j], nums[k], nums[l]});
                        ++k;
                        --l;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    }
                }
            }
        }
        return result;
    }
};