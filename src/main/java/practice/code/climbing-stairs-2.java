// Climbing Stairs
// 数学公式，时间复杂度O(1)，空间复杂度O(1)
public class Solution {
    public int climbStairs(int n) {
        final double s = Math.sqrt(5);
        return (int)Math.floor((Math.pow((1+s)/2, n+1) + 
            Math.pow((1-s)/2, n+1))/s + 0.5);
    }
};