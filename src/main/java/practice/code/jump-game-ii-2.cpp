// Jump Game II
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int jump(const vector<int>& nums) {
        int result = 0;
        // the maximum distance that has been reached
        int last = 0;
        // the maximum distance that can be reached by using "ret+1" steps
        int cur = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i > last) {
                last = cur;
                ++result;
            }
            cur = max(cur, i + nums[i]);
        }

        return result;
    }
};