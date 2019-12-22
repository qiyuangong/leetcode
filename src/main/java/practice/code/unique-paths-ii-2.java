// Unique Paths II
// 动规，滚动数组
// 时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] != 0 || 
                obstacleGrid[m-1][n-1] != 0) return 0;

        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] != 0 ? 0 : 1;

        for (int i = 0; i < m; i++) {
            f[0] = f[0] == 0 ? 0 : (obstacleGrid[i][0] != 0 ? 0 : 1);
            for (int j = 1; j < n; j++)
                f[j] = obstacleGrid[i][j] != 0 ? 0 : (f[j] + f[j - 1]);
        }

        return f[n - 1];
    }
}