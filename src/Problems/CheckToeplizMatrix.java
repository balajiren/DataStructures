package Problems;

public class CheckToeplizMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{6, 7, 8, 9, 2},
						  {4, 6, 7, 8, 9},
						  {1, 4, 6, 7, 8},
						  {0, 1, 3, 6, 7}};
		
		if(checkToepliz(matrix)){
			System.out.println("It is toepliz matrix.");
		}else{
			System.out.println("It is not a toepliz matrix.");
		}
	}
	
	public static boolean checkToepliz(int[][] matrix){
		for(int i=0; i<matrix.length-1; i++){
			for(int j=0; j<matrix[0].length-1; j++){
				if(matrix[i][j] != matrix[i+1][j+1]){
					return false;
				}
			}
		}
		return true;
	}

}
