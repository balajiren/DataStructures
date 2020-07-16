package ArrayQuestions;

public class BestTimeToSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int FindMaxProfit(int[] prices) {
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int price : prices) {
			
			min = Math.min(min, price);
			
		}

		for(int price : prices) {
			
			maxProfit = Math.max(maxProfit, price-min);
			
		}
		
		return maxProfit;
		
	}

}
