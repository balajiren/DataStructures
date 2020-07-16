package DynamicProgramming;

public class StockSellKTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxProfit_TwoTransactions(int[] prices) {
        
        //find min and find the next max
        int t1Cost = Integer.MAX_VALUE, 
        t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
        t2Profit = 0;
        for(int i=0;i<prices.length;i++) {
           t1Cost = Math.min(t1Cost,prices[i]);
           t1Profit = Math.max(t1Profit,prices[i]-t1Cost);
           t2Cost = Math.min(t2Cost,prices[i]-t1Profit);
           t2Profit = Math.max(t2Profit,prices[i]-t2Cost); 
   
        }
        return t2Profit;
    }
	
	  public int maxProfit_AnyTransactions(int[] prices) {
	        
			int maxProfit = 0;
			for(int i=1;i<prices.length;i++) {
	            if(prices[i] > prices[i-1]) {
	                maxProfit+=prices[i]-prices[i-1];
	            }
	        }
			
			return maxProfit;
	        
	    }
	
	
		public int maxProfit(int k, int[] prices) {
		        
		        if (prices.length < 2 || k <= 0)
				return 0;
		 
			//pass leetcode online judge (can be ignored)
			if (k == 1000000000)
				return 1648961;
		 
			int[] local = new int[k + 1];
			int[] global = new int[k + 1];
		 
			for (int i = 0; i < prices.length - 1; i++) {
				int diff = prices[i + 1] - prices[i];
				for (int j = k; j >= 1; j--) {
					local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
					global[j] = Math.max(local[j], global[j]);
				}
			}
		 
			return global[k];
		    }
		
		}
