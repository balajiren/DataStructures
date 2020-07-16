package Matrix;

public class MaximumSquare {
	
	 public static void main(String args[])
	    {
	      

	       int[][] costMatrix = { { 1,1,0,1}, { 1,1,0,1}, { 1,1,1,1}};
	        System.out.print(FindMaxSquare(costMatrix));
	    
	    }
	 
	 //logic  : Math.min(t[i][j-1], t[i-1][j], t[i-1][j-1])
	  public static int FindMaxSquare(int[][] board)
	  {
		  int m = board.length;
		  int n = board[0].length;
		  int[][] result = new int[m][n];
		  
		  for(int i=0;i< m;i++)
		  {
			  result[i][0] = board[i][0];
		  }
		  
		  for(int j=0;j< n;j++)
		  {
			  result[0][j] = board[0][j];
		  }
		  
		//cells inside
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (board[i][j] == 1) {
						int min = Math.min(result[i - 1][j], result[i - 1][j - 1]);
						min = Math.min(min,result[i][j - 1]);
						result[i][j] = min + 1;
					} else {
						result[i][j] = 0;
					}
				}
			}
		  int max =0;
		  //find max length
		  for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (result[i][j] > max) {
						max = result[i][j];
					}
				}
			}
		  
		  
		  return max*max;
		  
		  
		  
	  }
	    

}
