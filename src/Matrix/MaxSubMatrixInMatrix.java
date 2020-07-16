package Matrix;

public class MaxSubMatrixInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void subMatrix(int[][] arrA, int row, int cols) {
		int[][] sub = new int[row][cols];
		// copy the first row
		for (int i = 0; i < cols; i++) {
			sub[0][i] = arrA[0][i];
		}
		// copy the first column
		for (int i = 0; i < row; i++) {
			sub[i][0] = arrA[i][0];
		}

		// for rest of the matrix
		// check if arrA[i][j]==1
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < cols; j++) {
				if (arrA[i][j] == 1) {
					sub[i][j] = Math.min(sub[i - 1][j - 1],
							Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
				} else {
					sub[i][j] = 0;
				}
			}
		}
		// find the maximum size of sub matrix
		int maxSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (sub[i][j] > maxSize) {
					maxSize = sub[i][j];
				}
			}
		}
		System.out.println("Maximum size square sub-matrix with all 1s: " + maxSize);
	}

}
