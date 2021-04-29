class Solution {
    public int uniquePathsWithObstacles(int[][] og) 
    {
        int m = og.length-1;
        int n = og[0].length-1;
        int[][] dp = new int[m+1][n+1];
        dp[0][0]= 1;
        for ( int i = 0; i <= m; i++ )
        {
            for ( int j = 0; j <= n; j++)
            {
                if ( i == 0 && j == 0 ) { if ( og[i][j] == 1 ) dp[i][j] = 0; }
                else if ( i == 0 ) {
                    if ( og[i][j] == 1 ) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
                else if ( j == 0 ) {
                    if ( og[i][j] == 1 ) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else {
                    if ( og[i][j] == 1 ) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
                //System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
