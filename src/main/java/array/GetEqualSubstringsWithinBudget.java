package array;
import java.util.PriorityQueue;
public class GetEqualSubstringsWithinBudget {
	public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            // System.out.println( Math.abs(s.charAt(i) - t.charAt(i)) );
        }
        int sum = 0;
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < cost.length; i++) { 
            // If adding current element doesn't 
            // cross limit add it to current window 
            if ((sum + cost[i]) <= maxCost) { 
                sum += cost[i];  
                curLen++; 
            }  
      
            // Else, remove first element of current 
            // window. 
            else if(sum!=0) 
           { 
            sum = sum - cost[i - curLen] + cost[i]; 
           } 
            // keep track of max length. 
            maxLen = Math.max(curLen, maxLen);  
        } 
        return maxLen; 
    }
}
