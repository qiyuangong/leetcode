// Dungeon Game
// Time Complexity: O(mxn), Space Complexity: O(mxn)
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;
        if (m == 0 || n == 0) return 0;

        final int[][] f = new int[m][n];
        f[m-1][n-1] = Math.max(1, -dungeon[m-1][n-1]+1);

        for (int i = m - 2; i >= 0; --i) {
            f[i][n-1] = Math.max(1, -dungeon[i][n-1] + f[i+1][n-1]);
        }
        for (int j = n - 2; j >= 0; --j) {
            f[m-1][j] = Math.max(1, -dungeon[m-1][j] + f[m-1][j+1]);
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                f[i][j] = Math.max(1, -dungeon[i][j] + Math.min(f[i+1][j], f[i][j+1]));
            }
        }
        return f[0][0];
    }
}