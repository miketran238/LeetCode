import java.util.ArrayList;
import java.util.List;

import trie.PalindromePairs;

public class TestPalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePairs palinPair = new  PalindromePairs();
		String[] words = new String[] {"abcd","dcba","lls","s","sssll"};
		List<List<Integer>> res = palinPair.palindromePairs(words);
		for(List<Integer> list : res) {
			for( int i = 0; i < list.size(); i++ ) {
				System.out.print(list.get(i));
				if ( i != list.size()-1 ) System.out.print(","); //Not the last element
			}
			System.out.println();
		}
	}

}
