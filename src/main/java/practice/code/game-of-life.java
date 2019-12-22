// Game of Life
// Time complexity: O(mxn), Space complexity: O(1)
public class Solution {
    public void gameOfLife(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;
        // clock wise, start from upper-left corner
        final int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
        final int[] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

        // encode
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int live = 0; // number of live cells
                for (int k = 0; k < 8; ++k) {
                    final int x = i + dx[k];
                    final int y = j + dy[k];
                    if (x > -1 && x < m && y > -1 && y < n &&
                            (board[x][y] == 1 || board[x][y] == 2)) {
                        ++live;
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        //decode
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] %= 2;
            }
        }
    }
}