package DynamicProgramming;

//https://leetcode.com/problems/minimum-knight-moves/
public class MinimumKnightMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minKnightMoves(int x, int y) {
	        int[][] dp = new int[301][301];
	        return get(x, y, dp);
	    }
	    
	    private int get(int x, int y, int[][] dp) {
	        if (x == 0 && y == 0) return 0;
	        x = Math.abs(x);
	        y = Math.abs(y);
	        if (x + y == 2) return 2;
	        if (dp[x][y] > 0) return dp[x][y];
	        dp[x][y] = 1 + Math.min(get(x - 2, y - 1, dp), get(x - 1, y - 2, dp));
	        return dp[x][y];
	    }

}
