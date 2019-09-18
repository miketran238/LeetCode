//Note: This is an extension of 198. House Robber.
//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
//This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
//Meanwhile, the security system for these houses remain the same as for those in the previous street.
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.

//Basically the same as the First House Robber, but need to check twice for 2 cases:
//rob the first house (exclude the last) or vice versa
//*********************************** Beats 51.74% ***************************************************/
class Solution {
    public int rob(int[] nums) 
    {
        int one = 0, two = 0;
        int secLast = 0;
        int last = 0;
        if ( nums.length == 1 )
        {
            return nums[0];
        }
        for ( int i = 0; i < nums.length-1; i++ )
        {
            int temp = secLast;
            secLast = Math.max(secLast, last);
            last = temp + nums[i]; 
        }
        one = Math.max(secLast,last);
        secLast = 0;
        last = 0;
        for ( int i = 1; i < nums.length; i++ )
        {
            int temp = secLast;
            secLast = Math.max(secLast, last);
            last = temp + nums[i]; 
        }
        two = Math.max(secLast,last);
        return Math.max(one,two);
    }
}
