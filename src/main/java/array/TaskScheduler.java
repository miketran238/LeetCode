package array;

import java.util.Arrays;

public class TaskScheduler {
	    public int leastInterval(char[] tasks, int n) {
	        int[] map = new int[26];
	        for(char task : tasks) {
	            map[task-'A']++;
	        }
	        Arrays.sort(map);
	        int time = 0;
	        while ( map[25] > 0 ) {
	            int i = 0; //Cooling timer as well as offset to reduce other tasks
	            while ( i <= n ) {
	                if ( map[25] == 0 ) break;
	                if ( i < 26 && map[25-i] > 0 ) {
	                    map[25 - i]--;
	                } else{
	                    //Running out of tasks or idle. 
	                }
	                time++;
	                i++;
	            }
	            Arrays.sort(map);
	        }
	        return time;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskScheduler t = new TaskScheduler();
		int res = t.leastInterval(new char[] {'A', 'A','A','B','B','B'}, 3);
		System.out.println(res);
	}

}
