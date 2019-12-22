// Sudoku Solver
// 时间复杂度O(9^4)，空间复杂度O(1)
public class Solution {
    public void solveSudoku(char[][] board) {
        _solveSudoku(board);
    }
    private static boolean _solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; ++k) {
                        board[i][j] = Character.forDigit(k+1, 10);
                        if (isValid(board, i, j) && _solveSudoku(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        return true;
    }
    // 检查 (x, y) 是否合法
    private static boolean isValid(char[][] board, int x, int y) {
        int i, j;
        for (i = 0; i < 9; i++) // 检查 y 列
            if (i != x && board[i][y] == board[x][y])
                return false;
        for (j = 0; j < 9; j++) // 检查 x 行
            if (j != y && board[x][j] == board[x][y])
                return false;
        for (i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
            for (j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
                if ((i != x || j != y) && board[i][j] == board[x][y])
                    return false;
        return true;
    }
}