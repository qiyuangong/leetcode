// Unique Paths
// 深搜 + 缓存，即备忘录法
// 时间复杂度O(n^2)，空间复杂度O(n^2)
public class Solution {
    public int uniquePaths(int m, int n) {
        // f[x][y] 表示 从(0,0)到(x,y)的路径条数
        f = new int[m][n];
        f[0][0] = 1;
        return dfs(m - 1, n - 1);
    }

    int dfs(int x, int y) {
        if (x < 0 || y < 0) return 0; // 数据非法，终止条件

        if (x == 0 && y == 0) return f[0][0]; // 回到起点，收敛条件

        if (f[x][y] > 0) {
            return f[x][y];
        } else {
            return f[x][y] = dfs(x - 1, y) +  dfs(x, y - 1);
        }
    }
    private int[][] f;  // 缓存
}