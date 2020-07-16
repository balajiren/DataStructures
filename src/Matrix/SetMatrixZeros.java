package Matrix;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setXeroes(int[][]matrix)
	{
		
	   boolean firstrowzero = false;
	   boolean firstcolumnzero = false;
	   
	   for(int i=0;i<matrix.length;i++)
	   {
		   if(matrix[i][0] == 0)
		   {
			   firstcolumnzero = true;
		   }
		   
	   }
	   
	   for(int j=0;j<matrix[0].length;j++)
	   {
		   if(matrix[0][j] == 0)
		   {
			   firstrowzero = true;
		   }
		   
	   }
	   
	  
		
	   
	   for(int i=1;i<matrix.length;i++)
	   {
		   
		   for(int j=1;j<matrix[0].length;j++)
		   {
			   if(matrix[i][j] == 0)
			   {
				   matrix[i][0] = 0;
				   matrix[0][j] = 0;
			   }
			  
			   
		   }
		   
		   
		   
	   }
	   

	   for(int i=1;i<matrix.length;i++)
	   {
		   
		   for(int j=1;j<matrix[0].length;j++)
		   {
			   if(matrix[i][0] == 0 || matrix[j][0] == 0)
			   {
				   matrix[i][j] = 0;
			
			   }
			  
			   
		   }
		   
		   
		   
	   }
	   
	   for(int j=0;j<matrix[0].length;j++)
	   {
		   if(firstrowzero)
		   {
			   matrix[0][j] = 0;
		   }
	   }
	   
	   for(int j=0;j<matrix.length;j++)
	   {
		   if(firstcolumnzero)
		   {
			   matrix[j][0] = 0;
		   }
	   }
		
		
		
	}
	
	  public void setZeroes(int[][] matrix) {
	        boolean firstRowZero = false;
	        boolean firstColumnZero = false;
	 
	        //set first row and column zero or not
	        for(int i=0; i<matrix.length; i++){
	            if(matrix[i][0] == 0){
	                firstColumnZero = true;
	                break;
	            }
	        }
	 
	        for(int i=0; i<matrix[0].length; i++){
	            if(matrix[0][i] == 0){
	                firstRowZero = true;
	                break;
	            }
	        }
	 
	        //mark zeros on first row and column
	        for(int i=1; i<matrix.length; i++){
	            for(int j=1; j<matrix[0].length; j++){
	                if(matrix[i][j] == 0){
	                   matrix[i][0] = 0;
	                   matrix[0][j] = 0;
	                }
	            }
	        }
	 
	        //use mark to set elements
	        for(int i=1; i<matrix.length; i++){
	            for(int j=1; j<matrix[0].length; j++){
	                if(matrix[i][0] == 0 || matrix[0][j] == 0){
	                   matrix[i][j] = 0;
	                }
	            }
	        }
	 
	        //set first column and row
	        if(firstColumnZero){
	            for(int i=0; i<matrix.length; i++)
	                matrix[i][0] = 0;
	        }
	 
	        if(firstRowZero){
	            for(int i=0; i<matrix[0].length; i++)
	                matrix[0][i] = 0;
	        }
	 
	    }

}
