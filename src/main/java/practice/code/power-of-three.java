// Power of Three
// Time Complexity: O(1), Space Complexity: O(1)
public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}