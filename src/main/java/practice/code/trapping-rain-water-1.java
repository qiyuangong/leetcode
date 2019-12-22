// Trapping Rain Water
// 思路1，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int trap(int[] A) {
        final int n = A.length;
        int[] left_peak = new int[n];
        int[] right_peak = new int[n];

        for (int i = 1; i < n; i++) {
            left_peak[i] = Math.max(left_peak[i-1], A[i-1]);
        }
        for (int i = n - 2; i >=0; --i) {
            right_peak[i] = Math.max(right_peak[i+1], A[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int height = Math.min(left_peak[i], right_peak[i]);
            if (height > A[i]) {
                sum += height - A[i];
            }
        }

        return sum;
    }
};