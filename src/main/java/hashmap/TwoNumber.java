package hashmap;

import java.util.HashMap;


public class TwoNumber {
	public static int[] twoSum(int[] nums, int target) {
	    int[] result = new int[2];
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) 
	    {
	    	if(map.containsKey(target - nums[i]))
	    	{
	    		result[0] = map.get(target-nums[i]);
	    		result[1] = i;
	    		return result;
	    	}
	        map.put(nums[i], i);
	    }
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,4};
		int[] result = twoSum(nums,6);
		System.out.println(result[0] + "," + result[1]);
	}

}
