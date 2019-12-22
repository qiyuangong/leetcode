// Minimum Path Sum
// 备忘录法
public class Solution {
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        this.f = new int[m][n];
        for (int i = 0; i < m; ++i) Arrays.fill(f[i], -1);
        return dfs(grid, m-1, n-1);
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE; // 越界，终止条件，注意，不是0

        if (x == 0 && y == 0) return grid[0][0]; // 回到起点，收敛条件

        return Math.min(getOrUpdate(grid, x - 1, y),
                getOrUpdate(grid, x, y - 1)) + grid[x][y];
    }

    private int getOrUpdate(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE; // 越界，注意，不是0
        if (f[x][y] >= 0) return f[x][y];
        else return f[x][y] = dfs(grid, x, y);
    }
    private int[][] f;  // 缓存
}