// Majority Element
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        
        for (int x : nums) {
            if (count == 0) {
                result = x;
                count = 1;
            } else if (result == x) {
                ++count;
            } else {
                --count;
            }
        }
        return result;
    }
}