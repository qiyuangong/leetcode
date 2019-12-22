// N-Queens II
// 深搜+剪枝
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public int totalNQueens(int n) {
        this.count = 0;
        this.columns = new boolean[n];
        this.main_diag = new boolean[2 * n - 1];
        this.anti_diag = new boolean[2 * n - 1];

        int[] C = new int[n]; // C[i]表示第i行皇后所在的列编号
        dfs(C, 0);
        return this.count;
    }

    void dfs(int[] C, int row) {
        final int N = C.length;
        if (row == N) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            ++this.count;
            return;
        }

        for (int j = 0; j < N; ++j) {  // 扩展状态，一列一列的试
            final boolean ok = !columns[j] &&
                    !main_diag[row - j + N - 1] &&
                    !anti_diag[row + j];
            if (!ok) continue;  // 剪枝：如果合法，继续递归
            // 执行扩展动作
            C[row] = j;
            columns[j] = main_diag[row - j + N - 1] =
                    anti_diag[row + j] = true;
            dfs(C, row + 1);
            // 撤销动作
            // C[row] = -1;
            columns[j] = main_diag[row - j + N - 1] =
                    anti_diag[row + j] = false;
        }
    }

    private int count; // 解的个数
    // 这三个变量用于剪枝
    private boolean[] columns;   // 表示已经放置的皇后占据了哪些列
    private boolean[] main_diag; // 占据了哪些主对角线
    private boolean[] anti_diag; // 占据了哪些副对角线

    public static void main(String[] args) {
        Solution s = new Solution();
        s.totalNQueens(1);
    }
}