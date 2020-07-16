package Matrix;

public class WordSearch {

    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    public boolean backtrack(int row, int col, String word, int index) {

        if(index >= word.length()) {
            return true;
        }
        if(this.board[row][col] != word.charAt(index)) {
            return false;
        }

        this.board[row][col] = '#';

        int[] rowOffsets = {0,1,0,-1};
        int[] colOffsets = {1,0,-1,0};
        boolean ret = false;
         for(int d=0;d<4;d++) {
             ret = this.backtrack(row+rowOffsets[d], col+colOffsets[d], word, index+1);
             if(ret) {
                 return true;
             }
         }
        this.board[row][col]=word.charAt(index);
         return ret;

    }


}