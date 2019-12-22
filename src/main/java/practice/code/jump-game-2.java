// Jump Game
// 思路2，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        // 逆向下楼梯，最左能下降到第几层
        int left_most = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; --i)
            if (i + nums[i] >= left_most)
                left_most = i;

        return left_most == 0;
    }
}