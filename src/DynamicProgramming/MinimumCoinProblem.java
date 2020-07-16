 package DynamicProgramming;
 import java.util.*;

public class MinimumCoinProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 25, 50, 100 };
		int amount = 200;
		//MinCoinChange(20, coins);
		System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
				+ amount + " are: " +MinCoinChange(amount, coins));
	}
	
	
	
	public int coinChange(int[] coins, int amount) {
	      
	       if(amount == 0) {
	           return 0;
	       }
	       
	       int[] dp = new int[amount+1];
	       Arrays.fill(dp,Integer.MAX_VALUE);
	        
	       dp[0] = 0;
	        
	       for(int i=0;i<=amount;i++) {
	           
	           if(dp[i] == Integer.MAX_VALUE) {
	               continue;
	           }
	           for(int coin : coins) {
	                 if(i<=amount-coin) {
	                    dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
	                 }
	           }
	           
	       }
	        if(dp[amount] ==Integer.MAX_VALUE) {
	            return -1;
	        }
	        return dp[amount];
	        
	    }

	
	
	public static int MinCoinChange(int amount, int[] coins)
	{
		int[] solution = new int[amount+1];
		int[] iterSolution = new int[coins.length];
		solution[0] = 0;		
		
		for(int amt=1;amt <= amount; amt++)
		{
			for(int i=0;i<iterSolution.length;i++)
			{
				iterSolution[i] = -1;
			}
			
			for(int coin=0;coin<coins.length;coin++)
			{
				if(coins[coin] <= amt)
				{
					iterSolution[coin] = solution[amt-coins[coin]]+1 ;
				}
				
			}
			solution[amt]=-1;
			for(int j=1;j<iterSolution.length;j++)
			{
				if(iterSolution[j] > 0 && (solution[amt]==-1 || solution[amt] > iterSolution[j]))
				{
					solution[amt] =  iterSolution[j];
				}
			}
			
		}
		return solution[amount];	
	}
}
