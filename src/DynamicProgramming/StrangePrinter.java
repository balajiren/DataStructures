package DynamicProgramming;

public class StrangePrinter {
	int[][] memo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void CalculateTurns(String input) {
		int l = input.length();
		memo = new int[l][l];
		int result = dp(input,memo,0,l);
	}
	
	
	public static int  dp(String input, int[][] memo, int i, int j) {
		
		if( i > j) {
			return 0;
		}
		if(memo[i][j] == 0) {
			int ans = dp(input, memo, i+1,j)+1;
			for(int k=i+1;k<=j;k++) {
			  if(input.charAt(i) == input.charAt(j)) {
				  ans = Math.min(ans,dp(input,memo, i,k-1)+dp(input, memo,k+1, j));
			  }
			  memo[i][j] = ans;
			}
		}
	   return memo[i][j];
	}
	

}
