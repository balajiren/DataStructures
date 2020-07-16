package String;

import Common.Utils;

public class FindDistBetweenStringDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = FindDistance("intention", "execution");
		Utils.PrintMessage("Distance between String"+ result);

	}
	
	public static int FindDistance(String input1, String input2)
	{
		if(input1 == null || input2 == null)
		{
			return -1;
		}
		int rows = input1.length()+1;
		int cols = input2.length()+1;
		int[][] result = new int[rows+1][cols+1];
		
		//O(M*N)
		for(int m=0;m<rows;m++)
		{
			
			for(int n=0;n<cols;n++)
			{
				if(m ==0)
				{
					result[m][n]=n;
				}
				if(n ==0)
				{
					result[m][n]=m;
				}
				else if( m > 0 && n >0)
				{
					if(input1.charAt(m-1) == input2.charAt(n-1))
					{
						result[m][n] = result[m-1][n-1];
					}
					else
					{
						result[m][n] = Math.min(Math.min(1+result[m-1][n],1+result[m][n-1]),1+result[m-1][n-1]);
					}
				}
				
				
				
			}
			
			
		}
		return result[rows-1][cols-1];
		
	}

}
