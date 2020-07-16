package Matrix;

public class MinimalCostMatrix {

	 public static void main(String args[])
	    {
	      

	       int[][] costMatrix = { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, {6, 4, 3} };
	        System.out.print(FindMinimalCostPath(costMatrix));
	    
	    }
	    
	    
	    public static int FindMinimalCostPath(int[][] matrix)
	    {
	        int m =3;
	        int n = 2;
	        System.out.print(m);
	        int[][] solution = new int[m+1][n+1];
	        
	        solution[0][0] = matrix[0][0];
	        for(int i=1;i<=m;i++)
	        {
	            solution[i][0] = matrix[i][0]+ solution[i-1][0];
	        }
	        
	          for(int j=1;j<=n;j++)
	        {
	            solution[0][j] = matrix[0][j]+ solution[0][j-1];
	            
	        }
	        
	        for(int i=1;i<=m;i++)
	        {
	            for(int j=1;j<=n;j++)
	            {
	               
	              
	                solution[i][j] =   matrix[i][j]+minimum(solution[i-1][j], solution[i][j-1], solution[i-1][j-1]);
	            }
	        }
	        
	         return solution[m][n];
	        
	    }
	    
	    public static int minimum(int a, int b, int c) {
	        return Math.min(a, Math.min(b, c));
	    }

}
