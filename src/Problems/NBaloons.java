package Problems;

public class NBaloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//https://www.careercup.com/question?id=5719829237465088
	public static int MaxBaloons(int[] baloons)
	{
		
		int n = baloons.length;
		
		int dp[][] = new int[n][n];
		
		for(int k=2 ; k < n;k++)
		{
			for(int left = 0;  left < n-k; left++)
			{
				int right = left +k;
				for(int i=left+1;i < right ;i++)
				{
					dp[left][right] = Math.max(dp[left][right],baloons[left]+baloons[i]+ baloons[right]+dp[left][i]+dp[i][right]);
				}
			}
		}
		
		return dp[0][n-1];
	}

}
