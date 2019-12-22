// Single Number II
// 方法1，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int singleNumber(int[] nums) {
        final int W = Integer.SIZE; // 一个整数的bit数，即整数字长
        int[] count = new int[W];  // count[i]表示在在i位出现的1的次数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < W; j++) {
                count[j] += (nums[i] >> j) & 1;
                count[j] %= 3;
            }
        }
        int result = 0;
        for (int i = 0; i < W; i++) {
            result += (count[i] << i);
        }
        return result;
    }
};