package Matrix;

public class MinimalPathSum {

	public MinimalPathSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = 
			{
					  { 1,2,3,5},
					  { 4,5,6,9},
					  { 7,8,9,6},
					  { 7,3,1,6},
			};
		
		
		int result  = minPathSum(input);
		System.out.print(result);
		

	}
	
	
	//logic =  Math.min(result[i][j-1] + board[i][j], result[i-1][j] + boar[i][j])
	
	public static int minPathSum(int[][] grid) {
	    return dfs(0,0,grid);
	}
	 
	public static int dfs(int i, int j, int[][] grid){
	    if(i==grid.length-1 && j==grid[0].length-1){
	        return grid[i][j];
	    }
	 
	    if(i<grid.length-1 && j<grid[0].length-1){
	        int r1 = grid[i][j] + dfs(i+1, j, grid);
	        int r2 = grid[i][j] + dfs(i, j+1, grid);
	        return Math.min(r1,r2);
	    }
	 
	    if(i<grid.length-1){
	        return grid[i][j] + dfs(i+1, j, grid);
	    }
	 
	    if(j<grid[0].length-1){
	        return grid[i][j] + dfs(i, j+1, grid);
	    }
	 
	    return 0;
	}

	
	
	public static int GetMinimalPathSum1()
	{
		int[][] input = 
			{
					  { 1,2,3,5},
					  { 4,5,6,9},
					  { 7,8,9,6},
					  { 7,3,1,6},
			};
		
		
		int rowSize = input.length;
		int colsize = input[0].length;
		int[][] solution = new int[rowSize][colsize];
		for(int i=1;i<rowSize;i++)
		{
			solution[0][i] = solution[0][i-1] + input[0][i];
	
		}
		for(int j=1;j<colsize;j++)
		{
			solution[j][0] = solution[j-1][0] + input[j][0];
	
		}
		
		for(int i=1;i<rowSize;i++)
		{
			for(int j=1;j<colsize;j++)
			{
				if(solution[i-1][j] > solution[i][j-1])
				{
					solution[i][j] = input[i][j]+solution[i][j-1];
				} else
				{
					solution[i][j] = input[i][j]+solution[i-1][j];
				}
				
			}
	
		}
		return solution[rowSize-1][colsize-1];
		
	}
	
	
	public static int GetMinimalPathSum()
	{
		int[][] input =
			  {
				  { 1,2,3,5},
				  { 4,5,6,9},
				  { 7,8,9,6},
				  { 7,3,1,6},
				 
	         };
		
		int m = input.length;
		int n = input[0].length;
		int[][] result  = new int[m][n];
		
		for(int i=1;i<n;i++)
		{
			result[0][i] = result[0][i-1] + input[0][i];
		}
		for(int j=1;j<m;j++)
		{
			result[j][0] = result[j-1][0] + input[j][0];
		}
		
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				result[i][j]  = Math.min(result[i-1][j],result[i][j-1]) + input[i][j];
//				if(result[i-1][j] > result[i][j-1])
//				{
//					result[i][j] = result[i][j-1]+ input[i][j];
//				}
//				else
//				{
//					result[i][j] = result[i-1][j]+ input[i][j];
//				}
			}
		}
		return result[m-1][n-1];
	}

}
