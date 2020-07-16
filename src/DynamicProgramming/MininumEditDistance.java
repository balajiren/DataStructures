package DynamicProgramming;

public class MininumEditDistance {

	public MininumEditDistance() {
		// TODO Auto-generated constructor stub
	}
	
	  public static void main(String[] args) {
	        String s1 = "horizon";
	        String s2 = "horizontal";
	        System.out.println("Minimum Edit Distance -(DP): " + FindMinEditDistance(s1, s2));
	    }
	public static int FindMinEditDistance(String s1, String s2)
	{

		int[][] result = new int[s1.length()+1][s2.length()+1];
		
	   //base case
		for(int i=0;i<=s2.length();i++)
		{
			result[0][i] = i;
		}
		
		
		for(int j=0;j<=s1.length();j++)
		{
			result[j][0] = j;
		}
		
      
		int m  = s1.length();
		int n = s2.length();
		
		for(int i=1;i<=m;i++)
		{
			
			for(int j=1;j<=n;j++)
			{
				
				if(s1.charAt(i-1)  == s2.charAt(j-1))
				{
					result[i][j] = result[i-1][j-1];
				}
				else
				{
				 result[i][j] = 1+Math.min(result[i][j-1],Math.min(result[i-1][j],(result[i-1][j-1])));
				}
						
						
			}
		}
		
		return  result[s1.length()][s2.length()];
		
		
	}

}
