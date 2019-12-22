// Unique Paths II
// 深搜 + 缓存，即备忘录法
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] != 0 ||
                obstacleGrid[m - 1][n - 1] != 0) return 0;

        f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] != 0 ? 0 : 1;
        return dfs(obstacleGrid, m - 1, n - 1);
    }

    // @return 从 (0, 0) 到 (x, y) 的路径总数
    int dfs(int[][] obstacleGrid, int x, int y) {
        if (x < 0 || y < 0) return 0; // 数据非法，终止条件

        // (x,y)是障碍
        if (obstacleGrid[x][y] != 0) return 0;

        if (x == 0 && y == 0) return f[0][0]; // 回到起点，收敛条件

        if (f[x][y] > 0) {
            return f[x][y];
        } else {
            return f[x][y] = dfs(obstacleGrid, x - 1, y) +
                    dfs(obstacleGrid, x, y - 1);
        }
    }
    private int[][] f;  // 缓存
}