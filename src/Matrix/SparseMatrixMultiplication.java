package Matrix;

public class SparseMatrixMultiplication {
	

	
	public int[][] multiply(int[][] A, int[][] B) {
	    //validity check
	 
	    int[][] C = new int[A.length][B[0].length];
	 
	    for(int i=0; i<C.length; i++){
	        for(int k=0; k<A[0].length; k++){
	            if(A[i][k]!=0){
	                for(int j=0; j<C[0].length; j++){
	                    C[i][j] += A[i][k]*B[k][j];
	                }
	            }
	        }
	    }
	 
	    return C;
	}

}
