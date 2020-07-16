package Matrix;

//O(KLogN) k : Number of loops
public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countcomponent(int[][] edges, int n)
	{
		int[] root = new int[n];
		for(int i=0;i<n;i++)
		{
			root[i] =  i;
		}
		int count = n;
		for(int i=0;i<edges.length;i++)
		{
			int x = edges[i][0];
			int y = edges[i][1];
			int xRoot = getRoot(root, x);
		    int yRoot = getRoot(root, y);
			if(xRoot!= yRoot)
			{
				count--;
				//Union 2 edges and assign y as representative for the union set
				root[xRoot] = yRoot;
				
			}
		}
		return count;
		
	}

	// root : 1.. n , current : 2
	public static int getRoot(int[] root, int current)
	{
		
		while(root[current] != current)
		{
			root[current] = root[root[current]];
			current = root[current];
			
		}
		return current;
		
	}

}
