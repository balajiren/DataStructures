package Matrix;

public class ValidateTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validTicTacToe(String[] board) {
	    int n = board.length;
	    int[] rows = new int[n];
	    int[] cols = new int[n];
	    int[] diagonals = new int[2];
	    
	    int turns = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            char ch = board[i].charAt(j);
	            if (ch == 'X') {
	                turns++;
	                updateScores(rows, cols, diagonals, i, j, 1);
	            }
	            if (ch == 'O') {
	                turns--;
	                updateScores(rows, cols, diagonals, i, j, -1);
	            }   
	        }
	    }
	    boolean isWonByX = isWon(rows, cols, diagonals, n);
	    boolean isWonByY = isWon(rows, cols, diagonals, -n);
	    
	    if (isWonByX && turns != 1 || isWonByY && turns != 0) return false;
	    
	    return turns == 0 || turns == 1;
	}
	private void updateScores(int[] rows, int[] cols, int[] diagonals, int r, int c, int score) {
	    rows[r] += score;
	    cols[c] += score;
	    
	    if (r == c) diagonals[0] += score;
	    if (r + c == rows.length - 1) diagonals[1] += score;
	}

	private boolean isWon(int[] rows, int[] cols, int[] diagonals, int scores) {
	    for (int i = 0; i < rows.length; i++) {
	        if (rows[i] == scores || cols[i] == scores)
	            return true;
	    }
	    return diagonals[0] == scores || diagonals[1] == scores;
	}

}
