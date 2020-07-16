package Matrix;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   int[][] board = { { 1,5,9}, { 10,11,13}, { 12,14,15}};
		   int result  = kthSmallest(board,9);
		   System.out.println(result);

	}
	
	public static int kthSmallest(int[][] matrix, int k) {
	    int m=matrix.length;
	 
	    int lower = matrix[0][0];
	    int upper = matrix[m-1][m-1];
	 
	    while(lower<upper){
	        int mid = (lower + upper)/2;
	        int count = count(matrix, mid);
	        if(count<k){
	            lower=mid+1;
	        }else{
	            upper=mid;
	        }
	    }
	 
	    return upper;
	}
	
	private static int count(int[][] matrix, int target)
	{

		int m = matrix.length;
		int i = 0;
		int j = m-1;
		int count  = 0;
		
		while(i < m && j >= 0)
		{
			if(matrix[i][j] < target)
			{
				count+=1;
				i++;
			} else
			{
				j--;
			}
			
			
		}
		
		return count;
	}
	 
	
}
