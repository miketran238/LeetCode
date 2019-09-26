package array;
import java.util.HashSet;
import util.Pair;
/** Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
Ex1:
Input: [7,1,5,3,6,4]
Output: 5
Ex2:
Input: [7,6,4,3,1]
Output: 0
*/
/**
 * @author Mike
 * Objective: maximum profit
 * Constraints: buy one and sell one 
 */
public class BestTimetoBuyandSellStock {
	//Brute force: find all pairs of index i,j such that i < j and p[i] < p[j]
	//then find the maximum difference between them
	public int maxProfitBruteForce(int[] prices) 
    	{
		if ( prices.length < 2 ) return 0;
		HashSet<Pair> set = new HashSet<>();
		for ( int i = 0; i < prices.length-1; i++ ) {
			for (int j = i+1; j < prices.length; j++ ) {
				if ( prices[i] < prices[j] ) {
					set.add(new Pair(i,j));
				}
			}
		}
		int max = 0;
		for (Pair p : set) {
			int temp = prices[p.y] - prices[p.x];
			max = temp > max ? temp : max;
		}
		return max;
	}
	
	//Removing the set by comparing max in real time
	public int maxProfitBruteForceWithoutSet(int[] prices) 
    	{
		int max = 0;
		if ( prices.length < 2 ) return 0;
		for ( int i = 0; i < prices.length-1; i++ ) {
			for (int j = i+1; j < prices.length; j++ ) {
				int temp = prices[j] - prices[i];
				if ( temp > max ) max = temp;
			}
		}
		return max;
    	}
	
	//Jumping index i when we find a new local minimum
	public int maxProfitJumpingInterval(int[] prices) 
    	{
		int max = 0;
		if ( prices.length < 2 ) return 0;
		for ( int i = 0; i < prices.length-1; i++ ) {
			for (int j = i+1; j < prices.length; j++ ) {
                if ( prices[j] < prices[i] ) {
                    i = j-1;
                    break;
                }
                int temp = prices[j] - prices[i];
                if ( temp > max ) max = temp;
		return max;
    	}
	
	//Removing for loop over index i by using a local minimum variable
	/**
	 * Optimal solution
	 * O(n) running time, O(1) space
	 * @param prices
	 * @return maximum profit
	 */
    	public int maxProfit(int[] prices) 
    	{
		int max = 0;
		if ( prices.length < 2 ) return 0;
		int localMin = prices[0];
		for (int j = 1; j < prices.length; j++ ) {
		    if ( prices[j] < localMin ) {
			localMin = prices[j];
		    }
		    if ( prices[j] - localMin  > max ) {
			max = prices[j] - localMin;
		    }
		}
		return max;
    	}
}
