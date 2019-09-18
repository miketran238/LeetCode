import java.util.List;

import trie.WordSearch2;

public class TestWordSearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch2 ws2 = new WordSearch2();
		char[][] board = {{'a','b'},{'a','a'}};
		String[] words = new String[] {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		List<String> res = ws2.findWords(board, words);
		for(String r : res) {
			System.out.print(r + ", ");
		}
	}

}
