package trie;

import java.util.*;

/*
 * Given a list of string, find pairs such that 
 * concatenating the 2 strings will result in a palindrome
 */
public class PalindromePairs {
	/**
	 * There are two cases that s1 + s2 are palindrome Case 1: s2 is prefix of s1,
	 * s1 - s2 is palindrome Case 2: s1 is suffix of s2, s2 - s1 is palindrome
	 */
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> palindromePairs(String[] words) {
		TrieNode root = buildTrie(words);
		for (int i = 0; i < words.length; i++) {
			searchWord(words[i], root, i);
		}
		return res;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			TrieNode cur = root;
			char[] ca = words[i].toCharArray();
			for (int k = ca.length - 1; k >= 0; k--) {
				char c = ca[k];
				if (cur.children[c - 'a'] == null)
					cur.children[c - 'a'] = new TrieNode();
				if (isPalindrome(ca, 0, k))
					cur.list.add(i);
				cur = cur.children[c - 'a'];
			}
			cur.list.add(i);
			cur.index = i;
		}
		return root;
	}

	private void searchWord(String word, TrieNode root, int i) {
		char[] ca = word.toCharArray();
		TrieNode cur = root;
		for (int k = 0; k < ca.length; k++) {
			// Take care of the case str2 (represent by cur) is prefix of str1, and str1 -
			// str2 is palindrome
			if (cur.index >= 0 && cur.index != i && isPalindrome(ca, k, ca.length - 1))
				res.add(Arrays.asList(i, cur.index));
			cur = cur.children[ca[k] - 'a'];
			if (cur == null)
				return;
		}
		//This is a shortcut for adding pair (i, cur.index)
		//and the rest in the list. Instead we add a string own index into its list when build Trie
		for (int j : cur.list) {
			if (i == j)
				continue;
			res.add(Arrays.asList(i, j));
		}
	}

	private boolean isPalindrome(char[] ca, int left, int right) {
		while (left < right) {
			if (ca[left++] != ca[right--])
				return false;
		}
		return true;
	}

	class TrieNode {
		TrieNode[] children;
		int index;
		List<Integer> list;
		public TrieNode() {
			children = new TrieNode[26];
			index = -1;
			list = new ArrayList<Integer>();
		}
	}
}
