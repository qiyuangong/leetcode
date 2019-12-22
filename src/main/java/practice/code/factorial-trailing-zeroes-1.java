// Factorial Trailing Zeroes
// Time Complexity: O(nlogn), Space Complexity: O(1)
public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;

        for (int i = 1; i <= n; ++i) {
            int j = i;
            while (j % 5 == 0) {
                ++result;
                j /= 5;
            }
        }
        return result;
    }
}