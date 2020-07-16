package String;

public class LongestRepeatingSubSequence {
	
	
   public static void main(String args[]) {
	   
	   int result = FindLongestRepeatingSubSequence("aabbcc");
	   System.out.println(result);
   }
	

	public static int FindLongestRepeatingSubSequence(String input)
	{
		int n = input.length();
		int[][] result = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				
				if(input.charAt(i-1) == input.charAt(j-1) && i!=j)
				{
					result[i][j] = 1 + result[i-1][j-1];
				}
				else
				{
					result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
				}
			
			}
			
			
			
		}
		
		return result[n][n];
		
		
		
		
	}

}
