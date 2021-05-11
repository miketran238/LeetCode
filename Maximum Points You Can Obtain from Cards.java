class Solution {
    public int maxScore(int[] a, int k) {
        int n = a.length;
        //dp[i] = taking i card from the left
        int[] dp = new int[k+1];
        for(int i = 0; i < k ; i++) {
            dp[0] += a[n-i-1];
        }
        int res = dp[0];
        for(int i = 1; i < k+1; i++) {
            dp[i] = dp[i-1] + a[i-1] - a[n-k+i-1];
            res = Math.max(dp[i], res);
        }
        return res;
        // dp[i][j] = Math.max( dp[i+1,])
        // return recur(0,n-1, a, k);
    }
}
