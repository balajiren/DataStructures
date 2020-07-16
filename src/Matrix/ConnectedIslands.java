package Matrix;

public class ConnectedIslands {

	public ConnectedIslands() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] input = new char[][]
				{{'1', '1', '1','1','0'}, {'1', '1', '0','1','0'}, {'1', '1', '0','0','1'}, {'1', '1', '0','1','1'}};
		int result = CountIslands(input);
		System.out.print("Number of connected islands"+ result);

	}
	
	public static int CountIslands(char[][] input)
	{
		 if(input==null || input.length==0||input[0].length==0)
		        return 0;
		int m = input.length;
		int n = input[0].length;
		int count = 0;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(input[i][j] == '1')
				{
					count++;
					performDFSAndMerge(input,i,j);
				}
			}
			
		}
		return count;
	}
	
	public static void performDFSAndMerge(char[][] input, int i, int j)
	{
		int m = input.length;
		int n = input[0].length;
		if(i < 0  || i >= m || j < 0 || j >= n || input[i][j]!='1')
		{
			return;
		}
		input[i][j] = 'X';
		performDFSAndMerge(input, i-1,j);
		performDFSAndMerge(input, i+1,j);
		performDFSAndMerge(input, i,j-1);
		performDFSAndMerge(input, i,j+1);
		
	}

}
