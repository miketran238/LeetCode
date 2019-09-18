package recursion;

public class PrintReverseString {
	public void solution(String s) {
		if ( s.length() > 1) {
			solution(s.substring(1, s.length()));
		}
		System.out.print(s.charAt(0));
	}
	

}
