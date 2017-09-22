//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. 
//The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?

//************************* Beats 4.52% **********************//
class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];
        for ( int i = 1; i <= m; i++ )
        {
            for ( int j = 1; j <= n; j++)
            {
                if ( i == 1 && j == 1 )
                {
                    dp[0][0]= 1;
                }
                else if ( i == 1 || j==1)
                {
                    dp[i-1][j-1] = 1;
                }
                else
                {
                    dp[i-1][j-1] = dp[i-2][j-1] + dp[i-1][j-2];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
