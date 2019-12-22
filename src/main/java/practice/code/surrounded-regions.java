// Surrounded Regions
// BFS，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;

        final int m = board.length;
        final int n = board[0].length;
        for (int i = 0; i < n; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }
        for (int j = 1; j < m - 1; j++) {
            bfs(board, j, 0);
            bfs(board, j, n - 1);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '+')
                    board[i][j] = 'O';
    }
    private static void bfs(char[][] board, int i, int j) {
        Queue<State> q = new LinkedList<>();
        final int m = board.length;
        final int n = board[0].length;

        final Function<State, Boolean> stateIsValid = (State s) -> {
            if (s.x < 0 || s.x >= m || s.y < 0 || s.y >= n ||
                    board[s.x][s.y] != 'O')
                return false;
            return true;
        };
        final Function<State, ArrayList<State>> stateExtend = (State s) -> {
            ArrayList<State> result = new ArrayList<>();
            final int x = s.x;
            final int y = s.y;
            // 上下左右
            State[] newStates = new State[]{new State(x-1, y),
                    new State(x+1,y),
                    new State(x,y-1),
                    new State(x,y+1)
            };
            for (int k = 0; k < 4; ++k) {
                if (stateIsValid.apply(newStates[k])) {
                    // 既有标记功能又有去重功能
                    board[newStates[k].x][newStates[k].y] = '+';
                    result.add(newStates[k]);
                }
            }
            return result;
        };
        State start = new State(i, j);
        if (stateIsValid.apply(start)) {
            board[i][j] = '+';
            q.offer(start);
        }
        while (!q.isEmpty()) {
            State cur = q.poll();
            ArrayList<State> newStates = stateExtend.apply(cur);
            for (State s : newStates) q.offer(s);
        }
    }
    static class State {
        private int x;
        private int y;
        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}