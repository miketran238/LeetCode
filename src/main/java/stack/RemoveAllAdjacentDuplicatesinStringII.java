package stack;
import java.util.Stack;
public class RemoveAllAdjacentDuplicatesinStringII {
	public String removeDuplicates(String s, int k) {
        if ( s.length() < 2 ) return s;
        char[] ca = s.toCharArray();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(ca[0],1));
        for (int i = 1; i < ca.length; i++) {
            if ( ! stack.isEmpty() ) {
                char c = stack.peek().c;
                int len = stack.peek().len;
                //System.out.println(c + " " + len);
                if ( c == ca[i] ) { // A repeating character
                    len = len + 1;
                    if ( len == k ) {
                        for(int l = 1; l < k; l++) {
                            stack.pop();
                        }
                    }
                    else {
                        stack.push(new Pair(c,len));
                    }
                }
                else {             //A new character
                    stack.push(new Pair(ca[i],1));
                }
            } 
            else {
                stack.push(new Pair(ca[i],1));
            }
            
        }
        StringBuilder sb = new StringBuilder();
        while ( ! stack.isEmpty() ) {
            sb.insert(0,stack.pop().c);
        }
        return sb.toString();
    }
    
    class Pair {
        public char c;
        public int len;
        public Pair(char _c, int _len) {
            c = _c;
            len = _len;
        }
    }
}
