// Rotate Image
// 思路 2，时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public void rotate(final int[][] matrix) {
        final int n = matrix.length;

        for (int i = 0; i < n / 2; ++i) // 沿着水平中线反转
            for (int j = 0; j < n; ++j)
                swap(matrix, i, j, n - 1 - i, j);

        for (int i = 0; i < n; ++i)  // 沿着主对角线反转
            for (int j = i + 1; j < n; ++j)
                swap(matrix, i, j, j, i);
    }
    private static void swap(final int[][] matrix, 
            int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }
};