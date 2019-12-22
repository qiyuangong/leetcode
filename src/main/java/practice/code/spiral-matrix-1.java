// Spiral Matrix
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int beginX = 0, endX = matrix[0].length - 1;
        int beginY = 0, endY = matrix.length - 1;
        while (true) {
            // From left to right
            for (int j = beginX; j <= endX; ++j) result.add(matrix[beginY][j]);
            if (++beginY > endY) break;
            // From top to bottom
            for (int i = beginY; i <= endY; ++i) result.add(matrix[i][endX]);
            if (beginX > --endX) break;
            // From right to left
            for (int j = endX; j >= beginX; --j) result.add(matrix[endY][j]);
            if (beginY > --endY) break;
            // From bottom to top
            for (int i = endY; i >= beginY; --i) result.add(matrix[i][beginX]);
            if (++beginX > endX) break;
        }
        return result;
    }
}