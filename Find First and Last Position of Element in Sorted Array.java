class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1; 
        //find left then find right
        if ( n == 0 ) return new int[]{-1,-1};
        //First Bin search to find the lower bound
        while ( l < r ) {
            int m = l + ( r - l )/2;
            if ( nums[m] >= target ) r = m;
            else l = m + 1;
        }
        int left = nums[l] == target ? l : -1;
        l = 0; r = n-1; 
        //Bin search again, find the upper bound
        while ( l + 1 < r ) {
            int m = l + ( r - l )/2;
            if ( nums[m] <= target ) l = m; 
            else r = m - 1;
        }
        int right = nums[r] == target ? r : nums[l] == target ? l : -1;
        return new int[]{left,right};
    }
}
