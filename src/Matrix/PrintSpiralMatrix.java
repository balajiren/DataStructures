 package Matrix;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {

	public static void main(String[] args)
	{
		
		try
		{
		int[][] matrix = new int[][]
		                      {
								  { 1, 2, 3,5},
								  { 4, 5, 6,9},
								  { 7, 8, 9,6},
								  { 17, 18, 19,16},
								 
					         };
		
		 List<Integer> result = new ArrayList<Integer>();
		 //  if(matrix==null||matrix.length==0||matrix[0].length==0)
		 //       return result;
		 
		    int m = matrix.length;
		    int n = matrix[0].length;
		 
		    int left=0;
		    int right=n-1;
		    int top = 0;
		    int bottom = m-1;
		 
		    while(result.size()<m*n){
		        for(int j=left; j<=right; j++){
		        	System.out.print(matrix[top][j]);
		            result.add(matrix[top][j]);
		        }
		        top++;
		 
		        for(int i=top; i<=bottom; i++){
		        	System.out.print(matrix[i][right]);
		            result.add(matrix[i][right]);
		        }
		        right--;
		 
		        //prevent duplicate row
		        if(bottom<top)
		            break;
		 
		        for(int j=right; j>=left; j--){
		        	System.out.print(matrix[bottom][j]);
		            result.add(matrix[bottom][j]);
		        }
		        bottom--;
		 
		        // prevent duplicate column
		        if(right<left)
		            break;
		        
		        //left - move up
		        for(int i=bottom; i>=top; i--){
		        	System.out.print(matrix[i][left]);
		            result.add(matrix[i][left]);
		        }
		        left++;
		    }
	}
	
	catch(Exception ex)
	{
		
	}
		
	}
}
