// Single Number
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }
};