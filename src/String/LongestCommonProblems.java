package String;

import java.util.ArrayList;
import java.util.List;

import Common.Utils;

public class LongestCommonProblems {

	public LongestCommonProblems() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int length = FindLongestCommonSubsequence("LCLC","CLCL");
		//System.out.print(length);
		
		List<String> result = FindLongestCommonSubString("LCLC","XXL1SS");
		
		for(String res: result)
		{
			Utils.PrintMessage(res);
		}
		
	
	}
	
	
	
	
	private static List<String> FindLongestCommonSubString(String s1, String s2)
	{
		ArrayList<String> lst = new ArrayList<String>();
		int m = s1.length();
		int n = s2.length();
		if(s1.length() < 1 || s2.length() < 1)
		{
			return  null;
		}
		int[][] dp = new int[m+1][n+1];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				if(s1.charAt(i) == s2.charAt(j))
				{
					if(i==0 || j ==0)
					{
						dp[i][j] = 1;
					}
					else
					{
						dp[i][j] = 1+dp[i-1][j-1];
					}
			
					if(dp[i][j] > max)
					{
						max = dp[i][j];
						lst.add(s1.substring(i-max+1, i+1));
					
					}
					if(dp[i][j] == max)
					{
						lst.add(s1.substring(i-max+1, i+1));
					}
					
				}
				else
				{
					dp[i][j] = 0;
				}
				
			}
		}
		
		return lst;
	}
	
	private static int FindLongestCommonSubsequence(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();
		if(s1.length() < 1 || s2.length() < 1)
		{
			return -1;
		}
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				if(i== 0 || j == 0)
				{
					dp[i][j] = 0;
				}
				else if(s1.charAt(i-1) == s1.charAt(i-1))
				{
					dp[i+1][j+1] = 1 + dp[i][j];
				}
				else
				{
					dp[i+1][j+1] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
				
			}
		}
		
		return dp[m][n];
		
	}
	
	//Longest common subsequence Naive 2 POW N - WORST CASE
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] 
	  int lcs( char[] X, char[] Y, int m, int n )
	  {
	    if (m == 0 || n == 0)
	      return 0;
	    if (X[m-1] == Y[n-1])
	      return 1 + lcs(X, Y, m-1, n-1);
	    else
	      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
	  } */

}
