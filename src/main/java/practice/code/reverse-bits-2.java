// Reverse Bits
// Time Complexity: O(logn), Space Complexity: O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 0;
        int right = 31;
        while (left < right) {
            // swap bit
            int x = (n >> left) & 1;
            int y = (n >> right) & 1;

            if (x != y) {
                n ^= (1 << left) | (1 << right);
            }
            ++left;
            --right;
        }
        return n;
    }
}