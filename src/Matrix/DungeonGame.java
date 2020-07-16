package Matrix;

public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int CalculateKnightsHealth(int[][] matrix)
	{

		int  m = matrix.length;
		int n = matrix[0].length;
		
		
		int[][] minhealth  = new int[m][n];
	
	
		for(int i=m-1;i>=0;i--)
		{
			for(int j=n-1;j>=0;j--)
			{
				if(i == m-1 && j == n-1)
				{
					minhealth[i][j] = Math.max(1, matrix[i][j]);
				} else if( i == m-1)
				{
					minhealth[i][j] = Math.max(1, minhealth[i][j+1]-matrix[i][j]);
				}
				else if(j == n-1)
				{
					minhealth[i][j] = Math.max(1, minhealth[i+1][j]-matrix[i][j]);
				}
				else
				{
					minhealth[i][j] = Math.max(1,Math.min(minhealth[i+1][j], minhealth[i][j+1]) - matrix[i][j]);
				}
				
			}
		}
		
		
		return minhealth[0][0];

	}

}
