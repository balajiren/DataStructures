package DynamicProgramming;
import java.util.*;

public class SmallestAmountCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Time complexity is O(amount * num_of_coins) and space complexity is O(amount).
	public int coinChange(int[] coins, int amount) {
		
		int[] dp = new int[amount+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=0;i<=amount;i++) {
			
			if(dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			
			for(int j=0;j<coins.length;j++) {
				
				if(i<=amount-j) {
					dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
				}
				
			}
			
		}
		if(dp[amount]==Integer.MAX_VALUE){
	        return -1;
	    }
		
		
		return dp[amount];
	}

}
