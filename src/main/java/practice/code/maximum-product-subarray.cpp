// maximum-product-subarray
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];

        for(int i = 1; i < nums.size(); i++){
            int temp = maxLocal;
            maxLocal = max(max(nums[i] * maxLocal, nums[i]), nums[i] * minLocal);
            minLocal = min(min(nums[i] * temp, nums[i]), nums[i] * minLocal);
            global = max(global, maxLocal);
        }
        return global;
    }
};