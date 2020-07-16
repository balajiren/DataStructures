package ArrayQuestions;

public class IncreasingTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int x = Integer.MAX_VALUE;
	int y = Integer.MAX_VALUE;
	public boolean IncreasingTriplet(int[] nums)
	{
	  for(int i : nums)
	  {
	    int z = i;
	    if(x >= z)
	    {
	      x = z;
	    } else if (y >= z)
	    {
	      y = z;
	    }
	    else
	    {
	      return true;
	    }
	
	    
	  }
	   return false;
	  
	}	  

}
