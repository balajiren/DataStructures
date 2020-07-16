	package ArrayQuestions;

public class NumberOfConnectedIslands {

	 final static int[] offsets = {-1, 0, +1};
	 
	public static int FindNumberOfConnectedIslands(int[][] input) {
		// TODO Auto-generated constructor stub
		
		//boolean matric
		boolean[][] visited = new boolean[input.length][input[0].length];
		int count= 0;
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input[0].length;j++)
			{
				
				if(input[i][j] == 1 && !visited[i][j])
				{
					
					count+=1;
					PerformDFS(input, i, j, visited);
				}
				
				
			}
				
			
		}
		
		return count;
	}
	
	
	public static boolean IsNeighbour(int[][] input, int i, int j)
	{
		
		if((i >=0)  && (i<input.length) && (j >=0)  && (j<input[0].length))
		{
			if(input[i][j] == 1)
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void PerformDFS(int[][] input, int i, int j, boolean[][] visited)
	{
		
	if(visited[i][j])
	{
		return;
	}
	visited[i][j] = true;
	int xoffset; int yoffset;
	for(int oi=0;oi <  offsets.length;oi++)
	{
		xoffset = offsets[oi];
		for(int oj=0;oj < offsets.length;oj++)
		{
			yoffset = offsets[oj];
			
			if(xoffset == 0 && yoffset == 0)
			{
				continue;
			}
			//find neightbours
			if(IsNeighbour(input, i+xoffset, j + yoffset))
			{
				PerformDFS(input, i+xoffset, j + yoffset, visited);
			}
			
		}
		
	}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[][] input = new int[][]
				{
				
				 {0, 1, 0},

				 {1, 0, 1},

				 {0, 1, 0},
				
				
				};
		 
		 System.out.println(FindNumberOfConnectedIslands(input));

	}

}
