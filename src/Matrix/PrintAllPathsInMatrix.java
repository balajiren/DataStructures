package Matrix;

public class PrintAllPathsInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][]
				{
				  {1,2,3,4},
				  {5,6,3,4},
				  {5,6,3,4}
				  
				};
		
		int paths = PrintNumberOfPaths(input);
		System.out.print(paths);

	}
	
	
	public static int PrintNumberOfPaths(int[][] input)
	{
		int[][] result = new int[input.length][input.length];
		
		for(int i=0;i<input.length;i++)
		{
			result[i][0] = 1;
		}
		for(int j=0;j<input.length;j++)
		{
			result[0][j] = 1;
		}
		for(int i=1;i<input.length;i++)
		{
			for(int j=1;j<input.length;j++)
			{
				 if(result[i][j]!=-1){
				   result[i][j] = result[i-1][j]+result[i][j-1];
				 }
			}
			
			
		}
		
		return result[input.length-1][input.length-1];
		
	}

}
