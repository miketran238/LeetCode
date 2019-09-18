package trie;

import java.util.*;

//LeetCode problem 212. Word Search II
//https://leetcode.com/problems/word-search-ii/
/**
 * @author Mike
 * Built upon DFS solution: <link> 
 */
public class WordSearch2 {
	List<String> res = new ArrayList<>();
	public List<String> findWords(char[][] board, String[] words) {
		// DFS and Trie
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(root, i, j, board);
			}
		}
		return res;
	}

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (cur.children[c - 'a'] == null)
					cur.children[c - 'a'] = new TrieNode();
				cur = cur.children[c - 'a'];
			}
			cur.word = word;
		}
		return root;
	}

	public void dfs(TrieNode root, int i, int j, char[][] board) {
		char c = board[i][j];
		if (c == '!' || root.children[c - 'a'] == null)
			return;
		board[i][j] = '!';
		root = root.children[c - 'a'];
		if (root.word != null) {
			res.add(root.word);
			root.word = null; // Avoid reduntdant
		}
		if (i > 0)
			dfs(root, i - 1, j, board);
		if (j > 0)
			dfs(root, i, j - 1, board);
		if (i < board.length - 1)
			dfs(root, i + 1, j, board);
		if (j < board[0].length - 1)
			dfs(root, i, j + 1, board);
		board[i][j] = c;
	}
}
