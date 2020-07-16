package DynamicProgramming;

//Objec­tive: A child is climb­ing up a stair­case with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Imple­ment a method to count how many pos­si­ble ways the child can jump up the stairs.
public class NumberOfStairsToClimb {

	public NumberOfStairsToClimb() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		int[] result = new int[n+1];
		int ways = FindNumberOfWays(result,n);
		System.out.println(ways);

	}
	
	
	public static int FindNumberOfWays(int[] result, int n)
	{
		//base case
		if(n < 1)
		{
			return 0;
		}
		
		if(result[n] > 0)
		{
			return result[n];
		}		
		
		result[n] = 1 + FindNumberOfWays(result,n-1) + FindNumberOfWays(result,n-2) + FindNumberOfWays(result,n-3);
		return result[n];
		
		
	}

}
