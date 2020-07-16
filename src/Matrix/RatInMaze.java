package Matrix;

public class RatInMaze {

	public int[][] solution;
	public RatInMaze(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		
	}
	
	public boolean SolveMaze(int[][] maze, int length)
	{
		if(FindPath(maze,0,0,length,"down"))
		{
			print(solution, length);
		
		}
		return false;

		
	}
	
	public boolean FindPath(int[][] maze, int row, int column, int length, String direction)
	{
		
		if(row == length-1 || column == length -1)
		{
			solution[row][column] = 1;
			return true;
		}
		
		if(IsSafeToGO( maze,  row,  column,  length))
		{
			solution[row][column] = 1;
			if(FindPath(maze,  row+1,  column,  length,  "down"))
			{
				return true;
			}

			if(FindPath(maze,  row-1,  column,  length,  "down"))
			{
				return true;
			}

			if(FindPath(maze,  row,  column+1,  length,  "down"))
			{
				return true;
			}
			
			if(FindPath(maze,  row,  column-1,  length,  "down"))
			{
				return true;
			}
			
			solution[row][column] = 0;
			return false;
			
			
		}
		return false;
	}
	
	public void print(int [][] solution, int N){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean IsSafeToGO(int[][] maze, int row, int column, int length)
	{
	 
		if(row >=0 && column >=0 && row < length && column < length && maze[row][column]!=0)
		{
			return true;
		}
		return false;
	}

}
