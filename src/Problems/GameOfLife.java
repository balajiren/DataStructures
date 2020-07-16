package Problems;

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void gameOfLife1(int[][] board) {
	    int n = board.length, m = board[0].length;

	    int[] di = {-1, -1, -1,  0, 0,  1, 1, 1};
	    int[] dj = {-1,  0,  1, -1, 1, -1, 0, 1};

	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < m; j++) {
	        int live = 0;

	        for (int k = 0; k < 8; k++) {
	          int ii = i + di[k], jj = j + dj[k];

	          if (ii < 0 || ii >= n || jj < 0 || jj >= m)
	            continue;

	          if (board[ii][jj] == 1 || board[ii][jj] == 2) 
	            live++;
	        }

	        if (board[i][j] == 1 && (live < 2 || live > 3)) {
	          board[i][j] = 2;
	        } else if (board[i][j] == 0 && live == 3) { 
	          board[i][j] = 3;
	        }
	      }
	    }

	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < m; j++) { 
	        board[i][j] %= 2;
	      }
	    }
	  }
	
	

}
