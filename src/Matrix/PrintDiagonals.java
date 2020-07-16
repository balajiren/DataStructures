package Matrix;

public class PrintDiagonals {

	public static void main(String args[])
	{

	    int [][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	    long start = System.currentTimeMillis();
	     PrintAllDiagonals(input);

	 
	    
	}


	public static void PrintAllDiagonals(int[][] input)
	{
	    
	    int size = input.length;
	    int row = 0;
	    int col= 0;
	    
	    
	    
	    while(row < input.length)
	    {
	        col= 0;
	        int rowtemp = row;
	        while(rowtemp >=0)
	        {
	            System.out.print(input[rowtemp][col]+ " ");
	             rowtemp--;
	             col++;
	        
	            
	        }
	   
	        row++;
	    }
	   col = 1;
	  
	   while(col < input.length)
	   {
	        row = input.length -1;
	       int coltemp = col;
	       while(coltemp <= input.length-1)
	       {
	            System.out.print(input[row][coltemp]+ " ");
	            coltemp++;
	            row--;
	           
	       }
	       col++;
	   }
	    
	    
	}

}
