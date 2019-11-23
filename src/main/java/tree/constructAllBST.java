package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class constructAllBST {
	public static List<BTNode> traverseSet(Set<Integer> list) {
		List<BTNode> res = new ArrayList<>();
		for(Integer rootVal : list)
		{
			Set<Integer> bigger = new HashSet<Integer>();
			Set<Integer> smaller = new HashSet<Integer>();
			for(Integer i : list) {
				if ( i < rootVal ) smaller.add(i);
				if ( i > rootVal ) bigger.add(i);
			}
			List<BTNode> lefts = traverseSet(smaller);
			List<BTNode> rights = traverseSet(bigger);
			if ( lefts.size() == 0 ) {
				lefts.add(null);
			}
			if ( rights.size() == 0 ) {
				rights.add(null);
			}
			for( BTNode l: lefts) {
				for( BTNode r: rights) {
					BTNode root = new BTNode(rootVal);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
	
	public static List<BTNode> traverseList(ArrayList<Integer> al, int start, int end) {
		List<BTNode> res = new ArrayList<>();
		for(int i = start; i <= end; i++) {
			List<BTNode> lefts = traverseList(al, start, i-1);
			List<BTNode> rights = traverseList(al, i+1, end);
			if ( lefts.size() == 0 ) {
				lefts.add(null);
			}
			if ( rights.size() == 0 ) {
				rights.add(null);
			}
			for( BTNode l: lefts) {
				for( BTNode r: rights) {
					BTNode root = new BTNode(al.get(i));
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> list = new HashSet<>();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			list.add(i);
			al.add(i);
		}
		List<BTNode> result = traverseSet(list);
		//Already sorted list
		List<BTNode> result2 = traverseList(al, 0, al.size()-1);
		System.out.println("Done");
	}

}
