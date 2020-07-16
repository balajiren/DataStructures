package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class RobotInGridPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean FindPath(int[][] board)
	{
		int rows = board.length;
		int cols = board[0].length;
		int[] solution = new int[rows * cols + 1];
		List<Integer> lstPath = new ArrayList<Integer>();
		List<Integer> failedPoints = new ArrayList<Integer>();

		return IsPathExists(board, rows-1,cols,lstPath,failedPoints) ||IsPathExists(board, rows,cols-1,lstPath,failedPoints);
			
		
	}
	
	public static boolean IsPathExists(int[][] board, int currentRow, int currentCol, List<Integer> path, List<Integer> failedPoints)
	{
		for(int i = currentRow; i < board.length; i++)
		{
			for(int j= currentCol;j<board[0].length;j++)
			{
				if(board[i][j]  !='X')
				{
					path.add(board[i][j]);
				}
				else
				{
					failedPoints.add(board[i][j]);
				}
				if(board[i][j] ==  board[board.length][board[0].length])
				{
					return true;
				}
			}
			
			
		}
		return false;
	}

}
