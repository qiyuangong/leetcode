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