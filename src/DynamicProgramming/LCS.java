package DynamicProgramming;
import Common.Utils;
//subsequence
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = "ramendu".length();
		int n = "rmd".length();
		int c[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			c[i][0] = 0;
		}
		
		for(int j=0;j<=n;j++)
		{
			c[0][j] = 0;
		}
		
		for(int i=1;i<=m;i++)
		{
			
			for(int j=1;j<=n;j++)
			{
				if("ramendu".charAt(i-1) == "rmd".charAt(j-1))
				{
					
				     c[i][j] = c[i-1][j-1]+1;
				}
				else
				{
					c[i][j] = Math.max(c[i-1][j],c[i][j-1]);
				}
			}
		}
		Utils.PrintMessage("LCS IS :"+c[m][n]);

	}


}
