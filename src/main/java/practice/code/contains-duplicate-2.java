// Contains Duplicate
// Time Complexity: O(nlogn), Space Complexity: O(1)
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}