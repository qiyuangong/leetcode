// Majority Element
// Time Complexity: O(nlogn), Space Complexity: O(1)
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}