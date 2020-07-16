package DynamicProgramming;

//https://leetcode.com/problems/stone-game-ii/
public class StoneGame2 {
	
	 public int stoneGameII(int[] piles) {
		 
	        int[] sum = new int[piles.length+1];
	        int[][] dp = new int[piles.length+1][piles.length+1];
	        boolean[][] visited = new boolean[piles.length+1][piles.length+1];
		 
	        for(int i=1;i<sum.length;i++) {
	        	 sum[i] = sum[i-1] + piles[piles.length-i];
	        }
	        return search(piles,sum,dp,visited,1,piles.length);
		 
	 }
	 
	   private int search(int[] piles, int[] sum, int[][] dp, boolean[][] visited, int M, int left) {
		   
		   if (visited[left][M]) {
	            return dp[left][M];
	        }
		   
		   if (left <= 0) {
	            return 0;
	        }
		   
		   
	        if (left <= 2*M) {
	            dp[left][M] = sum[left];
	            visited[left][M] = true;
	            return sum[left];
	        }
	        
	        visited[left][M] = true;
	        int res = Integer.MAX_VALUE;
	        for (int i = 1; i <= 2*M; i++) {
	            res = Math.min(res, search(piles, sum, dp, visited, Math.max(M, i), left - i));
	        }
	        res = sum[left] - res;
	        dp[left][M] = res;
	        return res;
		   
		   
		   
	   }

}
