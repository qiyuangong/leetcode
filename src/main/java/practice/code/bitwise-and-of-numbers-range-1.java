// Bitwise AND of Numbers Range
// Time Complexity: O(log n), Space Complexity: O(1)
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;

        while ((m & mask) != (n & mask)) {
            mask = mask << 1;
        }
        return m & mask;
    }
}