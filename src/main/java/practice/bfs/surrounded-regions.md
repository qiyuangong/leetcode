## Surrounded Regions


### 描述

Given a 2D board containing `'X'` and `'O'`, capture all regions surrounded by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region .

For example,

```
X X X X
X O O X
X X O X
X O X X
```

After running your function, the board should be:

```
X X X X
X X X X
X X X X
X O X X
```

### 分析

广搜。从上下左右四个边界往里走，凡是能碰到的`'O'`，都是跟边界接壤的，应该保留。


### 代码

{% if book.java %}
```java
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
```
{% endif %}

{% if book.cpp %}
```cpp
// LeetCode, Surrounded Regions
// BFS，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    void solve(vector<vector<char>> &board) {
        if (board.empty()) return;

        const int m = board.size();
        const int n = board[0].size();
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
private:
    void bfs(vector<vector<char>> &board, int i, int j) {
        typedef pair<int, int> state_t;
        queue<state_t> q;
        const int m = board.size();
        const int n = board[0].size();

        auto state_is_valid = [&](const state_t &s) {
            const int x = s.first;
            const int y = s.second;
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
                return false;
            return true;
        };

        auto state_extend = [&](const state_t &s) {
            vector<state_t> result;
            const int x = s.first;
            const int y = s.second;
            // 上下左右
            const state_t new_states[4] = {{x-1,y}, {x+1,y},
                    {x,y-1}, {x,y+1}};
            for (int k = 0; k < 4;  ++k) {
                if (state_is_valid(new_states[k])) {
                    // 既有标记功能又有去重功能
                    board[new_states[k].first][new_states[k].second] = '+';
                    result.push_back(new_states[k]);
                }
            }

            return result;
        };

        state_t start = { i, j };
        if (state_is_valid(start)) {
            board[i][j] = '+';
            q.push(start);
        }
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            auto new_states = state_extend(cur);
            for (auto s : new_states) q.push(s);
        }
    }
};
```
{% endif %}