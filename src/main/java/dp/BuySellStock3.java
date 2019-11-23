package dp;

/**
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BuySellStock3 {
    //Must sell before buying
    //Maximum of 2 transactions 
    /**
1. sub-optimal problem? Max Profit F(i) at day i th
2. Problem variable: Day, b1, s1, b2, s2 (day of buy and sell)
3. Recurrent Relation: 
If b2 == -1: //Not buy 2
    if b1 == -1: //Not buy 1
        b1 = p(i)
    else:       //Bought 1
        if s1 == -1:    //Not sell 1
            if p(i) > b1:
                s1 = p(i)
                DP[i] = s1 - b1;
            else:
                b1 = p(i)
                Dp[i] = dp[i-1]
        else:           //Sell 1
            if p(i) > s1: //More profit
                s1 = p(i)
                DP[i] = s1 - b1;
            else:
                b2 = p(i)
                Dp[i] = Dp[i-1]

else:               //Buy 2
    if s2 == -1 //Not Sell 2
        if p(i) > b2:
            b2 = p(i)
            Dp[i] = Dp[i-1] + s2 - b2;
        else:
            Replace Max(b1,b2) with p(i)
            Reset variables
            Dp[i] = dp[i-1]
    else:
        if p(i) > s2
            s2 = p(i)
            Dp[i] = s1-b1+s2-b2
        else if p < Max(b1,b2) 
            Replace Max(b1,b2) with p(i)
            Reset variables
            Dp[i] = dp[i-1]

            
2,10,9,30: 8+21 = 29 > 28
4. Base Case
5. Iteratively or Recursively
6. Add memoization
7. O(n)
*/
    public int maxProfit(int[] p) {
        if ( p.length < 2 ) return 0;
        return 0;
        
    }
}