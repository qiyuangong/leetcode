// Unique Paths
// 深搜，小集合可以过，大集合会超时
// 时间复杂度O(n^4)，空间复杂度O(n)
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) return 0; // 终止条件

        if (m == 1 && n == 1) return 1; // 收敛条件

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}