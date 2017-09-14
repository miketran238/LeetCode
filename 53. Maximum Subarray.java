//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6. 

//14ms beats 87.79%

class Solution {
    public int maxSubArray(int[] nums) {
        //current max subarray
        int current = nums[0];
        int max = nums[0];
        for ( int i = 1; i < nums.length; i++ )
        {
            //if the current maxsubarray < 0, no point in adding it
            current = nums[i] + ( current > 0 ? current : 0 );
            max = Math.max(current,max);
        }
        return max;
    }
}
