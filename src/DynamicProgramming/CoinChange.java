package DynamicProgramming;
import java.util.*;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for(int coin=0;coin<coins.length;coin++) {

                if(coins[coin] <=i) {
                    dp[i] = Math.min(dp[i],dp[i-coins[coin]]+1);
                }

            }

        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
