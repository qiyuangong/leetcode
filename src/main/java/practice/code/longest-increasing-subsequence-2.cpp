// Longest Increasing Subsequence
// 时间复杂度O(nlogn)，空间复杂度O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> lis;
        for (auto x : nums) {
            int insertPos = lower_bound(lis, 0, lis.size(), x);
            if (insertPos >= lis.size()) {
                lis.push_back(x);
            } else {
                lis[insertPos] = x;
            }
        }
        return lis.size();
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