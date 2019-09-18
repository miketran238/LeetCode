//Find the contiguous subarray within an array (containing at least one number) which has the largest product.

//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6. 

//3ms beats 41.78%

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        //We only need to keep 2 memories
        int max = nums[0]; //1 maximum positive
        int min = nums[0]; //1 minimum negative
        for( int i = 1; i < nums.length; i++)
        {
            //Swap if current n0 < 0 
            if ( nums[i] < 0 )
            {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], nums[i]*max);
            min = Math.min(nums[i], nums[i]*min);
            result = Math.max(max,result);
        }
        return result;
    }
}
