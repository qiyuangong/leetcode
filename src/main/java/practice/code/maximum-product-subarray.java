// maximum-product-subarray
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int maxProduct(int[] nums) {
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minLocal);
            minLocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
}