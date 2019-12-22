// Bitwise AND of Numbers Range
// Time Complexity: O(log n), Space Complexity: O(1)
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= n - 1;
        }
        return m & n;
    }
}