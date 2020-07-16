package Recursion;

public class PossibleStepsInStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ways = CountNumberOfWays(4);
		System.out.println(ways);

	}
	
    public static int CountNumberOfWays(int n)
    {
    	if(n<1)
    	{
    		return 0;
    		
    	}
    	else 
    	{
    	    return 1 + CountNumberOfWays(n-1) + CountNumberOfWays(n-2) + CountNumberOfWays(n-3);
    	}
    	
    }
    
    
    
    
    
    public static int CountNumberOfWaysDynamic(int n, int[] dyn)
    {
   
	    if (n < 1) {
			return 0;
		}
		if (dyn[n] > 0) {
			return dyn[n];
		}
		dyn[n] = 1 + CountNumberOfWaysDynamic(n - 1, dyn) + CountNumberOfWaysDynamic(n - 2, dyn)
				+ CountNumberOfWaysDynamic(n - 3, dyn);
	    return dyn[n];
	
    }


}
