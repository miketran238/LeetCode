package array;
public class ProductofArrayExceptSelf {
    //Basically doing two passes
    //One from left, one from right
    //Merging the two give us the constant space analysis
    public int[] productExceptSelf(int[] nums) {
        if ( nums.length < 2 ) return nums;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        //Left pass
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int product = nums[nums.length-1];
        //Right pass
        for(int j = nums.length-2; j >= 0; j--) {
            ans[j] *= product;
            product *= nums[j];
        }
        return ans;
    }
}
