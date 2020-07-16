package Matrix;

import java.util.*;

public class FindPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] dx = {-1,0,1,0};
	int[] dy = {0,1,0,-1};
	
	public int[][] findPath(int[][] matrix)
	{
		
		int m = matrix.length;
		 
		int[][] result = new int[m][m];
	 
		ArrayList<int[]> temp = new ArrayList<int[]>();
		ArrayList<int[]> list = new ArrayList<int[]>();
	 
		dfs(matrix, 0, 0, temp, list);
		
		for(int i=0; i<list.size(); i++){
			result[list.get(i)[0]][list.get(i)[1]]=1;
			//System.out.println(Arrays.toString(list.get(i)));
		}
	 
		result[0][0]=1;
	 
		return result;
		
		
	}
	
	public static void dfs(int[][] board, int i, int j, ArrayList<int[]> temp, ArrayList<int[]> result)
	{
		int m = board.length;
		
		if(i == m-1 && j == m-1)
		{
			result.clear();
			result.addAll(temp);
			return;
		}
				
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int k=0; k<4;k++)
		{
			int x = dx[k] + i;
			int y = dy[k] + j;
			if(board[i][j] == 1 && x >=0  && y>=0)
			{
				temp.add(new int[]{x,y});
				int prev = board[x][y];
				board[x][y] = 0;
				dfs(board, x,y,temp,result);
				board[x][y] = prev;
				temp.remove(temp.size()-1);
				
				
			}
		}
		
		
		
	}

}
