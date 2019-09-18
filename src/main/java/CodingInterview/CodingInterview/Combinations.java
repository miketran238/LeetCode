package CodingInterview.CodingInterview;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1,new ArrayList<Integer>());
        return results;
    }
    
    public void backTrack ( int n, int k, int index, ArrayList<Integer> curr) {
        if ( curr.size() == k ) {
            results.add(new ArrayList<>(curr));
            return;
        }
        for ( int i = 1; i <= n; i++ ) {
            curr.add(i);
            backTrack(n,k,i,curr);
            curr.remove(curr.size()-1);
        }
        return;
    }
}
