package Matrix;

public class LongestIncreasingPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static int[] dx = {-1, 1, 0, 0};
	 static int[] dy = {0, 0, -1, 1};
	    
	    
	  public int IncreasingPath(int[][] matrix) 
	   {
		   int[] max = new int[1];
		   for(int i=0; i<matrix.length; i++)    {
		        for(int j=0; j<matrix[0].length; j++){
		        	performdfs(matrix, i, j, max,1);
		        }
		    }
		    return max[0];
	   }
	   public static void performdfs(int[][] matrix,int i, int j, int[] res, int len)
	   {
		   res[0] = Math.max(len,res[0]);
		   int m = matrix.length;
		   int n = matrix[0].length;
		   for(int k=0;k<4;k++)
		   {
			    int x = dx[k] + i;
			    int y= dy[k]+ j;
			   if(x>=0 && x<m && y>=0 && y<n && matrix[x][y] > matrix[i][j])
			   {
				   performdfs(matrix, x,y, res, len+1);
			   }
		   }
	   }
			   
// 2ND APPROACH
	    public int longestIncreasingPath(int[][] matrix) {
	        if(matrix==null||matrix.length==0||matrix[0].length==0)
	            return 0;
	 
	        int[][] mem = new int[matrix.length][matrix[0].length];
	        int longest=0;
	 
	        for(int i=0; i<matrix.length; i++){
	            for(int j=0; j<matrix[0].length; j++){
	                longest = Math.max(longest, dfs(matrix, i, j, mem));
	            }
	        }
	 
	        return longest;
	    }
	 
	    public int dfs(int[][] matrix, int i, int j,  int[][] mem){
	    	
	        if(mem[i][j]!=0)
	            return mem[i][j];
	 
	        for(int m=0; m<4; m++){
	            int x = i+dx[m];
	            int y = j+dy[m];
	 
	            if(x>=0&&y>=0&&x<matrix.length&&y<matrix[0].length&&matrix[x][y]>matrix[i][j]){
	                mem[i][j]=Math.max(mem[i][j], dfs(matrix, x, y, mem));
	            }
	        } 
	 
	        return ++mem[i][j];
	    }

}
