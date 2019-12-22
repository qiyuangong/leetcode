## N-Queens


### 描述

The **n-queens puzzle** is the problem of placing n queens on an `n × n` chessboard such that no two queens attack each other.

![Eight Queens](../images/8-queens.png)

Given an integer `n`, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

```
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
```


### 分析

经典的深搜题。

设置一个数组 `vector<int> C(n, 0)`, `C[i]` 表示第i行皇后所在的列编号，即在位置 `(i, C[i])`上放了一个皇后，这样用一个一维数组，就能记录整个棋盘。


### 代码1

{% if book.java %}
```java
// N-Queens
// 深搜+剪枝
// 时间复杂度O(n!*n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] C = new int[n]; // C[i]表示第i行皇后所在的列编号
        dfs(C, 0, result);
        return result;
    }
    private static void dfs(int[] C, int row, List<List<String>> result) {
        final int N = C.length;
        if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                char[] charArray = new char[N];
                Arrays.fill(charArray, '.');
                for (int j = 0; j < N; ++j) {
                    if (j == C[i]) charArray[j] = 'Q';
                }
                solution.add(new String(charArray));
            }
            result.add(solution);
            return;
        }

        for (int j = 0; j < N; ++j) {  // 扩展状态，一列一列的试
            final boolean ok = isValid(C, row, j);
            if (!ok) continue;  // 剪枝，如果非法，继续尝试下一列
            // 执行扩展动作
            C[row] = j;
            dfs(C, row + 1, result);
            // 撤销动作
            // C[row] = -1;
        }
    }

    /**
     * 能否在 (row, col) 位置放一个皇后.
     *
     * @param C 棋局
     * @param row 当前正在处理的行，前面的行都已经放了皇后了
     * @param col 当前列
     * @return 能否放一个皇后
     */
    private static boolean isValid(int[] C, int row, int col) {
        for (int i = 0; i < row; ++i) {
            // 在同一列
            if (C[i] == col) return false;
            // 在同一对角线上
            if (Math.abs(i - row) == Math.abs(C[i] - col)) return false;
        }
        return true;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// N-Queens
// 深搜+剪枝
// 时间复杂度O(n!*n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<string> > solveNQueens(int n) {
        vector<vector<string> > result;
        vector<int> C(n, -1);  // C[i]表示第i行皇后所在的列编号
        dfs(C, result, 0);
        return result;
    }
private:
    void dfs(vector<int> &C, vector<vector<string> > &result, int row) {
        const int N = C.size();
        if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            vector<string> solution;
            for (int i = 0; i < N; ++i) {
                string s(N, '.');
                for (int j = 0; j < N; ++j) {
                    if (j == C[i]) s[j] = 'Q';
                }
                solution.push_back(s);
            }
            result.push_back(solution);
            return;
        }

        for (int j = 0; j < N; ++j) {  // 扩展状态，一列一列的试
            const bool ok = isValid(C, row, j);
            if (!ok) continue;  // 剪枝，如果非法，继续尝试下一列
            // 执行扩展动作
            C[row] = j;
            dfs(C, result, row + 1);
            // 撤销动作
            // C[row] = -1;
        }
    }
    
    /**
     * 能否在 (row, col) 位置放一个皇后.
     *
     * @param C 棋局
     * @param row 当前正在处理的行，前面的行都已经放了皇后了
     * @param col 当前列
     * @return 能否放一个皇后
     */
    bool isValid(const vector<int> &C, int row, int col) {
        for (int i = 0; i < row; ++i) {
            // 在同一列
            if (C[i] == col) return false;
            // 在同一对角线上
            if (abs(i - row) == abs(C[i] - col)) return false;
        }
        return true;
    }
};
```
{% endif %}


### 代码2

{% if book.java %}
```java
// N-Queens
// 深搜+剪枝
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        this.columns = new boolean[n];
        this.main_diag = new boolean[2 * n - 1];
        this.anti_diag = new boolean[2 * n - 1];

        List<List<String>> result = new ArrayList<>();
        int[] C = new int[n];
        Arrays.fill(C, -1); // C[i]表示第i行皇后所在的列编号
        dfs(C, 0, result);
        return result;
    }
    

    private void dfs(int[] C, int row, List<List<String>> result) {
        final int N = C.length;
        if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                char[] charArray = new char[N];
                Arrays.fill(charArray, '.');
                for (int j = 0; j < N; ++j) {
                    if (j == C[i]) charArray[j] = 'Q';
                }
                solution.add(new String(charArray));
            }
            result.add(solution);
            return;
        }

        for (int j = 0; j < N; ++j) {  // 扩展状态，一列一列的试
            final boolean ok = !columns[j] && !main_diag[row - j + N - 1]  &&
                    !anti_diag[row + j];
            if (!ok) continue;  // 剪枝，如果非法，继续尝试下一列
            // 执行扩展动作
            C[row] = j;
            columns[j] = main_diag[row - j + N - 1] = anti_diag[row + j] = true;
            dfs(C, row + 1, result);
            // 撤销动作
            // C[row] = -1;
            columns[j] = main_diag[row - j + N - 1] = anti_diag[row + j] = false;
        }
    }
    // 这三个变量用于剪枝
    private boolean[] columns;  // 表示已经放置的皇后占据了哪些列
    private boolean[] main_diag;  // 占据了哪些主对角线
    private boolean[] anti_diag;  // 占据了哪些副对角线
}
```
{% endif %}

{% if book.cpp %}
```cpp
// N-Queens
// 深搜+剪枝
// 时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<string> > solveNQueens(int n) {
        this->columns = vector<bool>(n, false);
        this->main_diag = vector<bool>(2 * n - 1, false);
        this->anti_diag = vector<bool>(2 * n - 1, false);

        vector<vector<string> > result;
        vector<int> C(n, -1);  // C[i]表示第i行皇后所在的列编号
        dfs(C, result, 0);
        return result;
    }
private:
    // 这三个变量用于剪枝
    vector<bool> columns;  // 表示已经放置的皇后占据了哪些列
    vector<bool> main_diag;  // 占据了哪些主对角线
    vector<bool> anti_diag;  // 占据了哪些副对角线

    void dfs(vector<int> &C, vector<vector<string> > &result, int row) {
        const int N = C.size();
        if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            vector<string> solution;
            for (int i = 0; i < N; ++i) {
                string s(N, '.');
                for (int j = 0; j < N; ++j) {
                    if (j == C[i]) s[j] = 'Q';
                }
                solution.push_back(s);
            }
            result.push_back(solution);
            return;
        }

        for (int j = 0; j < N; ++j) {  // 扩展状态，一列一列的试
            const bool ok = !columns[j] && !main_diag[row - j + N - 1]  &&
                    !anti_diag[row + j];
            if (!ok) continue;  // 剪枝，如果非法，继续尝试下一列
            // 执行扩展动作
            C[row] = j;
            columns[j] = main_diag[row - j + N - 1] = anti_diag[row + j] = true;
            dfs(C, result, row + 1);
            // 撤销动作
            // C[row] = -1;
            columns[j] = main_diag[row - j + N - 1] = anti_diag[row + j] = false;
        }
    }
};
```
{% endif %}


### 相关题目

* [N-Queens II](n-queens-ii.md)
