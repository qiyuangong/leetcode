// Jump Game
// 思路三，动规，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public boolean canJump(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1], nums[i - 1]) - 1;
            if (f[i] < 0) return false;;
        }
        return f[nums.length - 1] >= 0;
    }
}