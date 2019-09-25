package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		List<List<Integer>> result = sol.combinationSum(new int[] {2,3,6,7}, 7);
		for ( List<Integer> l : result) {
			for ( Integer i : l ) {
				System.out.print(i + ",");
			}
			System.out.println();
		}

	}
}

class Solution {
	    /**
	    Backtracking solution
	    Since candidates are w/o duplicates, as long as we backtrack correctly
	    (process cand one by one, a fail solution leads to backtrack and explore another solution),
	    we don't need to worry about the non-unique combinations
	    */
	public List<List<Integer>> re = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    Arrays.sort(candidates);
	    backtrack(new ArrayList<>(), candidates, target, 0);
	    return re;
	}
	public void backtrack(List<Integer> curr, int[] cand, int target, int index) {
	    if ( target == 0 ) {
	        re.add(new ArrayList<>(curr));
	        return;
	    }
	    for ( int i = index; i < cand.length; i++ ) {
	        if ( target - cand[i] >= 0 ) {
	            curr.add(cand[i]);
	            backtrack(curr, cand, target-cand[i], index++);
	            curr.remove(curr.size()-1);
	        } else
	            return;
	    }
	    return;
	}
}