package binSearch;

public class UglyNumberIII {
	//Greatest common divider
	private long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
	}
	
	//Lowest common multiplier
	private long lcm(long a, long b) {
		return a*b/ gcd(a,b);
	}
	
	private int count(int num, int a, int b, int c) {
		return (int)( num/a + num/b + num/c - num/lcm(a,b) - num/lcm(b,c) - num/lcm(a,b) + num/lcm(a,lcm(b,c)) );
	}
	public int nthUglyNumber(int n, int a, int b, int c) {
		int low = 0, high = Integer.MAX_VALUE;
		while ( low < high ) {
			int mid = low + (high-low)/2;
			int k = count(mid, a, b, c);
			if ( k >= n ) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		return low;
	}
}
