// Missing Number
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        final int n = nums.length;
        final int sumExpected = (n * (n + 1)) / 2;
        return sumExpected - sum;
    }
}