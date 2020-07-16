package Matrix;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePathsWithObstacles_DP(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }
	
	
	public static int UniquePathDFS(int[][] input, int rowIndex, int colIndex)
	{
		
		int m = input.length;
		int n = input[0].length;
		
		if(rowIndex ==  m -1 && colIndex ==  n-1)
		{
			return 1;
		}
		if(rowIndex < m-1 && colIndex < n-1)
		{
			return UniquePathDFS(input, rowIndex+1, colIndex) + UniquePathDFS(input, rowIndex, colIndex+1);
		}
		if(rowIndex < m-1)
		{
			return UniquePathDFS(input, rowIndex+1, colIndex);
		}
		if(colIndex < n-1)
		{
			return  UniquePathDFS(input, rowIndex, colIndex+1);
		}
		
		return 0;
	}
	
	
	public int uniquePaths(int m, int n) {
	    if(m==0 || n==0) return 0;
	    if(m==1 || n==1) return 1;
	 
	    int[][] dp = new int[m][n];
	 
	    //left column
	    for(int i=0; i<m; i++){
	        dp[i][0] = 1;
	    }
	 
	    //top row
	    for(int j=0; j<n; j++){
	        dp[0][j] = 1;
	    }
	 
	    //fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	 
	    return dp[m-1][n-1];
	}


}
