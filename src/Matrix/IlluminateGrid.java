package Matrix;

public class IlluminateGrid {

	int[] cols;
	int[] rows;
	int[] leftdiagonals;
	int[] rightdiagonals;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	IlluminateGrid(int n, int[][] lamps)
	{
		cols = new int[n];
		rows = new int[n];
		leftdiagonals = new int[(n-1) * 2 + 1];
		rightdiagonals = new int[(n-1) * 2 + 1];
				
		for(int[] lamp : lamps)
		{
			addLamp(lamp);
		}
		
	}
	
	public void addLamp(int[] lamp)
	{
		int x = lamp[0];
		int y = lamp[1];
		cols[x]++;
		rows[y]++;
		leftdiagonals[x+y]++;
		rightdiagonals[x-y]++;
	}
	
	public boolean IsIlluminated(int x, int y)
	{
		return (cols[x] > 0 || rows[y] > 0|| leftdiagonals[x+y] > 0 || rightdiagonals[x-y] > 0);
	}

}
