// N-Queens II
// 深搜+剪枝
// 时间复杂度O(n!*n)，空间复杂度O(n)
public class Solution {
    public int totalNQueens(int n) {
        this.count = 0;
        
        int[] C = new int[n]; // C[i]表示第i行皇后所在的列编号
        dfs(C, 0);
        return this.count;
    }
    
    void dfs(int[] C, int row) {
        final int n = C.length;
        if (row == n) { // 终止条件，也是收敛条件，意味着找到了一个可行解
            ++this.count;
            return;
        }

        for (int j = 0; j < n; ++j) {  // 扩展状态，一列一列的试
            final boolean ok = isValid(C, row, j);
            if (!ok) continue;  // 剪枝：如果合法，继续递归
            // 执行扩展动作
            C[row] = j;
            dfs(C, row + 1);
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
    private int count; // 解的个数
}