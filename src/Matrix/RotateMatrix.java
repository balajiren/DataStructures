package Matrix;

public class RotateMatrix {

	public RotateMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Time complexity : \mathcal{O}(N^2)O(N //Space O(1)

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	public void rotate_simple(int[][] matrix) {
        //Transpose rows and cols
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse the rowsn i.e put fist element to last and last to first
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
	
	 private static void RotateMatrix(int[][] matrix, int n)
	    {
	        
	        int size = matrix.length;
	        for(int layer=0; layer<=n/2 ; layer++)
	        {
	            
	            int first = layer;
	            int last =   n - 1 - layer;
	            
	            for(int i=first;i<last;i++)
	            {
	                
	                int offset = i - first;
	                int top = matrix[first][i];
	                
	                //left to top'
	                matrix[first][i] = matrix[last-offset][first];
	                
	                //top  to right
	                matrix[i][last] = top;
	                
	                //bottom to left
	                matrix[last-offset][first] = matrix[last][last-offset];
	                
	                //right to bottom
	                matrix[last][last-offset] = matrix[i][last];
	                
	            }
	        }
	        
	        
	        
	        
	        
	    }
	    
	    

}
