package Matrix;

import java.util.Arrays;

public class Search2DMatrix {

	public Search2DMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = Search2DMatrix();
		System.out.print(result);

	}
	
	private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
	
	
	public boolean SearchSortedmatrix_Binary(int[][] matrix, int target)
	{
    
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0;
		int end = m*n -1;
		while (start <=end)
		{
			int mid= (start+end) / 2;
			int midX= mid / n;
			int midY = mid % n;
			
			if(matrix[midX][midY] == target)
			{
				return true;
			}
			if(matrix[midX][midY] > target)
			{
				end = mid -1;
				
			}
			else
			{
				start = mid+1;
			}
			
		}
		
		return false;
	}
	
	
	public static int Search2DMatrix() {
		int[][] input =
			  {
				  { 1, 2, 3,5},
				  { 4, 5, 6,9},
				  { 7, 8, 9,6},
				  { 17, 18, 19,16},
				 
	         };
		int target = 19;
		int m = input.length;
		int n = input[0].length;
		int start = 0;
		int end  = m*n-1;

		while(start <= end)
		{
			int mid = (start+end) /2;
			int midx =  (int) Math.ceil(mid / n);
			int midy = (int) Math.ceil(mid % n);
			if(input[midx][midy] == target)
			{
				return input[midx][midy];
			}
			if(input[midx][midy] < target)
			{
				start = mid+1;
			}
			else
			{
				end = mid -1;
			}
		}
		return -1;
	}

}
