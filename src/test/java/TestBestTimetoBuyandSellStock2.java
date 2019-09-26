import array.BestTimetoBuyandSellStock2;
public class TestBestTimetoBuyandSellStock2 {
	public static void main(String[] args) {
		BestTimetoBuyandSellStock2 buysellStock = new BestTimetoBuyandSellStock2();
		System.out.println(buysellStock.maxProfit(new int[] {7,1,5,3,6,4})); //Assert 7
		System.out.println(buysellStock.maxProfit(new int[] {7,6,4,3,1})); //Assert 0
		System.out.println(buysellStock.maxProfit(new int[] {2,1,2,0,1})); //Assert 2
	}
}
