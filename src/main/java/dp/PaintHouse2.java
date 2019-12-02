package dp;

import java.util.Collections;
import java.util.PriorityQueue;

/*
There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0; 
 costs[1][2] is the cost of painting house 1 with color 2, and so on... 
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

public class PaintHouse2 {
	public int paintHouse(int[][] cost) {
		int n = cost.length;
		if ( n == 0 ) return 0;
		int k = cost[0].length;
		int[][] dp = new int[n][k+1];
		for(int j = 0; j < k; j++) {
			dp[0][j] = cost[0][j];
		}
		
		//Need 3 values: preIndex, preMin, and preSecond
		//PreIndex: index of the last chosen color
		//PreMin: Min of last house
		//PreSecond: Second minimum
		int preMin = 0, preSec = 0;
		int preIdx = -1;
		for(int i = 0; i < n; i++) {
			int curMin = Integer.MAX_VALUE, curSec = Integer.MAX_VALUE;
			int curIdx = 0;
			for(int j = 0; j < k; j++) {
				if ( j == preIdx ) {
					cost[i][j] += preSec ;
				} else {
					cost[i][j] += preMin;
				}
				if ( cost[i][j] < curMin ) {
					curSec = curMin;
					curMin = cost[i][j];
					curIdx = j;
				} else if ( cost[i][j] < curSec ) {
					curSec = cost[i][j];
				}
				//dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + cost[i][j];
			}
			preIdx = curIdx;
			preMin = curMin;
			preSec = curSec;
		}
		int result = Integer.MAX_VALUE;
	    for(int j=0; j<cost[0].length; j++){
	        if(result>cost[cost.length-1][j]){
	            result = cost[cost.length-1][j];
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		PaintHouse2 ph = new PaintHouse2();
		int[][] cost = new int[][] { {17,2,17} , {16,16,5}, {14,3,19} };
		System.out.println(ph.paintHouse(cost));
	}
	
}
