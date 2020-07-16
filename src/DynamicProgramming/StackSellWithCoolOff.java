package DynamicProgramming;

public class StackSellWithCoolOff {
	
//	b0 = Math.max(b1, s2 - prices[i]);
//	s0 = Math.max(s1, b1 + prices[i]);
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/240097/Come-on-in-you-will-not-regret-most-general-java-code-like-all-other-DP-solutions
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
         
        int b1 = -prices[0];
         
        int s2 = 0;
        int s1 = 0;
         
        for (int i = 1; i <= prices.length; i++) {
            int b0 = Math.max(b1, s2 - prices[i - 1]);
            int s0 = Math.max(s1, b1 + prices[i - 1]);
             
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
         
        return s1;
    }
	
	
//	sold[i]=hold[i−1]+price[i]
//	held[i]=max(held[i−1],reset[i−1]−price[i])
//	reset[i]=max(reset[i−1],sold[i−1])
	public int maxProfit_1(int[] prices) {

	    int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

	    for (int price : prices) {
	      int preSold = sold;

	      sold = held + price;
	      held = Math.max(held, reset - price);
	      reset = Math.max(reset, preSold);
	    }

	    return Math.max(sold, reset);
	  }

}
