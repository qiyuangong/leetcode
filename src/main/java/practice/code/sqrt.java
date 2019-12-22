// LeetCode, Sqrt(x)
// 二分查找
// 时间复杂度O(logn)，空间复杂度O(1)
public class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x / 2;
        int last_mid = -1;  // 记录最近一次mid

        if (x < 2) return x;

        while(left <= right) {
            final int mid = left + (right - left) / 2;
            if(x / mid > mid) { // 不要用 x > mid * mid，会溢出
                left = mid + 1;
                last_mid = mid;
            } else if(x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return last_mid;
    }
}