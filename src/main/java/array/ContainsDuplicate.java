package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ContainsDuplicate {
	public boolean containsDuplicateNotWorkAgainstIntegerExValues(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for ( int n : nums ) {
			if ( n < min ) min = n;
			if ( n > max ) max = n;
		}
		boolean[] checked = new boolean[max-min+1];
		for ( int n : nums ) {
			if ( checked[n-min] ) return true;
			checked[n-min] = true;
		}
		return false;
	}
	
	public boolean containsDuplicateOneLine (int [] nums) {
		return nums.length > (Arrays.stream(nums).boxed().collect(Collectors.toSet())).size();
	}
	
	public boolean containsDuplicate (int [] nums) {
		HashSet<Integer> set = new HashSet<>();
		for( int n : nums ) {
			if ( set.contains(n) ) return true;
			set.add(n);
		}
		return false;
	}
}
