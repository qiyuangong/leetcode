// Single Number
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }
};