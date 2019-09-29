package hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberofOccurrences {
	public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> check = new HashSet<>();
        for(int a : arr) {
            map.put(a, map.getOrDefault(a,0)+1);
        }
        for(int key : map.keySet()) {
            int val = map.get(key);
            if ( check.contains(val) ) {
                return false;
            }
            check.add(val);
        }
        return true;
    }
}
