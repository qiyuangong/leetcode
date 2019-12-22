// Unique Paths
// 动规，滚动数组
// 时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 左边的f[j]，表示更新后的f[j]，与公式中的f[i][j]对应
                // 右边的f[j]，表示老的f[j]，与公式中的f[i-1][j]对应
                f[j] = f[j] + f[j - 1];
            }
        }
        return f[n - 1];
    }
}