package Matrix;

	// A simple Java program to implement Game of Life
	public class GameOfLife
	{
	    public static void main(String[] args)
	    {
	        int M = 10, N = 10;
	 
	        // Intiliazing the grid.
	        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	        };
	 
	        // Displaying the grid
	        System.out.println("Original Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (grid[i][j] == 0)
	                    System.out.print(".");
	                else
	                    System.out.print("*");
	            }
	            System.out.println();
	        }
	        System.out.println();
	        nextGeneration(grid, M, N);
	    }
	    
	    //Game of life with O(M*N) memory and O(1) Space
	    public void gameOfLife(int[][] board) {

	        // Neighbors array to find 8 neighboring cells for a given cell
	        int[] neighbors = {0, 1, -1};

	        int rows = board.length;
	        int cols = board[0].length;

	        // Iterate through board cell by cell.
	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {

	                // For each cell count the number of live neighbors.
	                int liveNeighbors = 0;

	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {

	                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
	                            int r = (row + neighbors[i]);
	                            int c = (col + neighbors[j]);

	                            // Check the validity of the neighboring cell.
	                            // and whether it was originally a live cell.
	                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
	                                liveNeighbors += 1;
	                            }
	                        }
	                    }
	                }

	                // Rule 1 or Rule 3
	                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
	                    // -1 signifies the cell is now dead but originally was live.
	                    board[row][col] = -1;
	                }
	                // Rule 4
	                if (board[row][col] == 0 && liveNeighbors == 3) {
	                    // 2 signifies the cell is now live but was originally dead.
	                    board[row][col] = 2;
	                }
	            }
	        }

	        // Get the final representation for the newly updated board.
	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                if (board[row][col] > 0) {
	                    board[row][col] = 1;
	                } else {
	                    board[row][col] = 0;
	                }
	            }
	        }
	    }
	    
	    
	  
	    // Function to print next generation
	    static void nextGeneration(int grid[][], int M, int N)
	    {
	        int[][] future = new int[M][N];
	 
	        // Loop through every cell
	        for (int l = 1; l < M - 1; l++)
	        {
	            for (int m = 1; m < N - 1; m++)
	            {
	                // finding no Of Neighbours that are alive
	                int aliveNeighbours = 0;
	                for (int i = -1; i <= 1; i++)
	                    for (int j = -1; j <= 1; j++)
	                        aliveNeighbours += grid[l + i][m + j];
	 
	                // The cell needs to be subtracted from
	                // its neighbours as it was counted before
	                aliveNeighbours -= grid[l][m];
	 
	                // Implementing the Rules of Life
	 
	                // Cell is lonely and dies
	                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
	                    future[l][m] = 0;
	 
	                // Cell dies due to over population
	                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
	                    future[l][m] = 0;
	 
	                // A new cell is born
	                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
	                    future[l][m] = 1;
	 
	                // Remains the same
	                else
	                    future[l][m] = grid[l][m];
	            }
	        }
	 
	        System.out.println("Next Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (future[i][j] == 0)
	                    System.out.print(".");
	                else
	                    System.out.print("*");
	            }
	            System.out.println();
	        }
	    }
	}


