package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input1 = "balaji".toCharArray();
		char[] input2 = "calai".toCharArray();
		//test();
		FindCommonSubStringDynamic(input1,input2);

	}
	
	
	public static int getLongestCommonSubstring(String a, String b){
		int m = a.length();
		int n = b.length();
	 
		int max = 0;
	 
		int[][] dp = new int[m][n];
	 
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(a.charAt(i) == b.charAt(j)){
					if(i==0 || j==0){
						dp[i][j]=1;
					}else{
						dp[i][j] = dp[i-1][j-1]+1;
					}
	 
					if(max < dp[i][j])
						max = dp[i][j];
				}
	 
			}
		}
	 
		return max;
	}

	
	public static void FindCommonSubStringDynamic(char[] input1, char[] input2)
	{
		int M = input1.length;
		int N = input2.length;
		int[][] lcs = new int[M+1][N+1];
		for(int i=M-1;i >=0;i--)
		{
			for(int j=N-1;j >=0;j--)
			{
				if(input1[i] == input2[j])
				{
					lcs[i][j] = 1+ lcs[i+1][j+1];
				}
				else
				{
					lcs[i][j] = Math.max(lcs[i+1][j], lcs[i][j+1]);
				}
			}
		}
		//System.out.print(Arrays.deepToString(lcs));
		
		int i=0;int j=0;
		while(i<M && j<N)
		{
			if(input1[i] == input2[j])
			{
				System.out.print(input1[i]);
				i++;
				j++;
			}
			else if (lcs[i+1][j] >= lcs[i][j+1])
			{
				i++;
				j++;
			}
			else
			{
				
			}
			System.out.println();
		}
		
		
	}

}
