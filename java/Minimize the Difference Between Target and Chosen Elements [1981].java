class Solution {
    public int minimizeTheDifference(int[][] a, int k) {
        n=a.length;
        m=a[0].length;        
        min=Integer.MAX_VALUE;
        dp=new boolean[n][5000];
        solve(a,k,0,0,0);
        return min;
    }
    private void solve(int a[][],int k,int sum,int row,int col)
    {
        if(dp[row][sum]) return;
        if(n-1==row)
        {
            for(int i=0;i<m;i++)
            min=Math.min(min,Math.abs(k-sum-a[row][i]));
            dp[row][sum]=true;
            return;
        }
        
        for(int i=0;i<m;i++)
            solve(a,k,sum+a[row][i],row+1,col);
        dp[row][sum]=true;
    }
    private int min;
    private int dy[],n,m;
    private boolean dp[][];
}
