package sort;

public class TestSort {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int[] nums = {1,3,4,2};
		QuickSort sort = new QuickSort(nums);
		sort.quickSort(0, nums.length-1);
		for(Integer i: nums)
		{
			System.out.print(i + ",");
		}
		System.out.println();

	}

}
