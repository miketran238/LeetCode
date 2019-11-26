package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
	
	public int leastIntervalQueue(char[] tasks, int n) {
		int[] map = new int[26];
		for(char task : tasks) {
			map[task-'A']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(
	            new Comparator<Integer>() {
	            @Override
	            public int compare(Integer s1, Integer s2) {
	                return s2 - s1;
	            }
	        }
	        );
		for( int m : map) {
			if ( m > 0 ) {
				pq.add(m);
			}
		}
		int time = 0;
		while ( !pq.isEmpty() ) {
			int i = 0; //Cool down
			ArrayList<Integer> temp = new ArrayList<>();
			while ( i <= n ) {
				if ( !pq.isEmpty()) {
					if ( pq.peek() > 1 ) {
						temp.add(pq.poll()-1);
					}
					else {
						pq.poll();
					}
				} 
				time++;
				//If q is empty but temp is not. The processor runs idle
				if ( pq.isEmpty() && temp.isEmpty() ) break;
				i++;
			}
			for(int t: temp) {
				pq.add(t);
			}
		}
		return time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskScheduler t = new TaskScheduler();
		int res = t.leastIntervalQueue(new char[] {'A', 'A','A','B','B','B'}, 3);
		System.out.println(res);
	}

}
