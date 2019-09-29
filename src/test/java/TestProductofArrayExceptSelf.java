import array.*;
public class TestProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();
		int[] res = solution.productExceptSelf(new int[]{1,2,3,4});
		for(int r : res) {
			System.out.print(r + " ");
		}
	}

}
