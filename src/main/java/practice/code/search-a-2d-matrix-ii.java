// Search a 2D Matrix II
// 时间复杂度O(m + n)，空间复杂度O(1)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;

        int i = 0;
        int j = matrix[0].length-1;
        while(i < matrix.length && j >= 0) {
            final int x = matrix[i][j];
            if(target == x) {
                return true;
            } else if (x < target) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }
}