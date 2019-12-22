// Jump Game
// 思路1，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public boolean canJump(int[] nums) {
        int reach = 1; // 最右能跳到哪里
        for (int i = 0; i < reach && reach < nums.length; ++i)
            reach = Math.max(reach,  i + 1 + nums[i]);
        return reach >= nums.length;
    }
}