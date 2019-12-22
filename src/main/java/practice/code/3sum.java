// 3Sum
// 先排序，然后左右夹逼，注意跳过重复的数
// Time Complexity: O(n^2)，Space Complexity: O(1)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        final int target = 0;
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                } else if(nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while(nums[k] == nums[k+1] && j < k) --k;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                    while(nums[k] == nums[k+1] && j < k) --k;
                }
            }
        }
        return result;
    }
};