// Spiral Matrix
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        left = 0;
        right = matrix[0].length - 1;
        up = 0;
        down = matrix.length - 1;
        dfs(matrix, 0, 0, 0, result);
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int direction,
                     List<Integer> result) {
        if (i < up || i > down) return;
        if (j < left || j > right) return;
        result.add(matrix[i][j]);

        int nextDirection = (direction + 1) % 4;
        switch (direction) {
            case 0:  // right
                if (j < right) {
                    dfs(matrix, i, j + 1, direction, result);
                } else {
                    ++up;
                    dfs(matrix, i + 1, j, nextDirection, result);
                }
                break;
            case 1:  // down
                if (i < down) {
                    dfs(matrix, i+1, j, direction, result);
                } else {
                    --right;
                    dfs(matrix, i, j - 1, nextDirection, result);
                }
                break;
            case 2:  // left
                if (j > left) {
                    dfs(matrix, i, j - 1, direction, result);
                } else {
                    --down;
                    dfs(matrix, i - 1, j, nextDirection, result);
                }
                break;
            default: // up
                if (i > up) {
                    dfs(matrix, i - 1, j, direction, result);
                } else {
                    ++left;
                    dfs(matrix, i, j + 1, nextDirection, result);
                }
        }

    }

    private int left;
    private int right;
    private int up;
    private int down;
}