package dp;
/*
 * There are a row of n houses, each house can be painted with one of the three colors: 
 * red, blue or green. The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
	The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
	For example, costs[0][0] is the cost of painting house 0 with color red; 
	costs[1][2] is the cost of painting house 1 with color green, and so on... 
	Find the minimum cost to paint all houses.
 */

/**
1. What is the sub-optimal problem? min cost to paint to house i
2. Problem variable: last painted house, ith house --> Need a 2D array: dp[i][3] 
3. Recurrent Relation: dp[i+1][jth] = MinOf (dp[i][0], ...dp[i][j-1],dp[i][j+1], ...dp[i][k])
4. Base Case
5. Iteratively or Recursively
6. Add memoization
7. O(n)
*/

public class PaintHouse {
	public int paintHouse(int[][] cost) {
		int n = cost.length;
		int[][] dp = new int[n][3];
		for(int j = 0; j < 3; j++) {
			dp[0][j] = cost[0][j];
		}
		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
		}
		return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
	}
	
	public static void main(String[] args) {
		PaintHouse ph = new PaintHouse();
		int[][] cost = new int[][] { {17,2,17} , {16,16,5}, {14,3,19} };
		System.out.println(ph.paintHouse(cost));
	}
	
}
