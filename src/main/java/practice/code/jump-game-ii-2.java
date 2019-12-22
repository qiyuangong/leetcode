// Jump Game II
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int jump(int[] nums) {
        int result = 0;
        // the maximum distance that has been reached
        int last = 0;
        // the maximum distance that can be reached by using "ret+1" steps
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > last) {
                last = cur;
                ++result;
            }
            cur = Math.max(cur, i + nums[i]);
        }

        return result;
    }
}