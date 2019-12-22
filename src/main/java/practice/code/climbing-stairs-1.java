// Climbing Stairs
// 迭代，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int climbStairs(int n) {
        int prev = 0;
        int cur = 1;
        for(int i = 1; i < n+1 ; ++i){
            int tmp = cur;
            cur += prev;
            prev = tmp;
        }
        return cur;
    }
};