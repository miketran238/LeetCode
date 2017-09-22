//You are a professional robber planning to rob houses along a street. 
//Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
//it will automatically contact the police if two adjacent houses were broken into on the same night.
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.

//Strategy: Basically a Dp problem
//Max value can be robbed at house i = Max Of (max value at(i-2) + ValueAtHouse(i), max value at (i-1))   
//*************** Beats 29.04% ********************//
class Solution {
    public int rob(int[] num) 
    {
        int len = num.length;
        if (len == 0 ) {
            return 0;
        }
        if (len == 1 ) {
            return num[0];
        }
        int b4Last = num[0], last = Math.max(num[0],num[1]);
        for( int i = 2; i < len; i++ )
        {
            int temp = b4Last;
            b4Last = last;
            last = Math.max(temp + num[i],last);
            //dp[i] = Math.max(dp[i-2]+num[i], dp[i-1]); //will act as dp[i-1] in the next iter
        }
        return last;
    }
}
