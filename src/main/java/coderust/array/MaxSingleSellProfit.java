package coderust.array;

public class MaxSingleSellProfit {


	private int findMaxSingleSellProfit(int[] price) {
		int minPrice = price[0];
		int maxDiff = 0;
		
		for(int i=1; i<price.length; i++) {
			if(price[i] < minPrice) {
				minPrice = price[i];
			}
			if(maxDiff < (price[i] - minPrice)) {
				maxDiff = price[i] - minPrice;
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		 // int price[] = {100, 180, 260, 310, 40, 535, 695};
		 int price[] = {100, 99, 98, 97, 96, 95, 94};
		 int profit = new MaxSingleSellProfit().findMaxSingleSellProfit(price);
		 System.out.println(profit);
	}
}