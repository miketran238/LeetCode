import array.BestTimetoBuyandSellStock;
public class TestBestTimetoBuyandSellStock {
	public static void main(String[] args) {
		BestTimetoBuyandSellStock buysellStock = new BestTimetoBuyandSellStock();
		System.out.println(buysellStock.maxProfit(new int[] {7,1,5,3,6,4})); //Assert 5
		System.out.println(buysellStock.maxProfit(new int[] {7,6,4,3,1})); //Assert 0
		System.out.println(buysellStock.maxProfit(new int[] {2,1,2,0,1})); //Assert 1
	}
}
