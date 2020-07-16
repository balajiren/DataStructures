package DynamicProgramming;
//https://leetcode.com/problems/minimum-cost-for-tickets/solution/
import java.util.*;
public class MinCostTickets {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
 public int GetMinCost(int[] days, int[] costs) {

     this.costs = costs;
     memo = new Integer[366];
     dayset = new HashSet();
     for (int d: days) dayset.add(d);
     return dp(1);
 }

 public int dp(int day) {
     int ans = 0;
     if (day > 365)
         return 0;
     if (memo[day] != null)
         return memo[day];

     if(dayset.contains(day)) {
       ans = Math.min(dp(day+1) + costs[0], dp(day+7) + costs[1]);
       ans = Math.min(ans,dp(day+30) + costs[30]);

     } else {
         ans = dp(day+1);
     }
     memo[day] = ans;
  return ans;
 }


}
