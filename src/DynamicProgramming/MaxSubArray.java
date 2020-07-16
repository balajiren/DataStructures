package DynamicProgramming;

public class MaxSubArray {

	public MaxSubArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
		  System.out.println("Maximum subarray is  " + FindMaxSubArray(arrA));
	}
	
	public static int maxContiguousSubArray(int[] nums)
	{
		int[] solution = new int[nums.length];
		solution[0] = 0;
		int max = 0;
		 for(int i=1;i<nums.length;i++)
		 {
			 solution[i] = Math.max(nums[i] + solution[i-1], nums[i]);
			 max = Math.max(max, solution[i]);
			 
		 }
			 
		return max;
		
	}
	
	public static int FindMaxSubArray(int[] arr)
	{
		
		int[] solution = new int[arr.length+1];
		
		solution[0] = 0;
		for(int i=1; i < solution.length ; i++)
		{

			solution[i] = Math.max(solution[i-1]+ arr[i-1], arr[i-1]);
		}
		
	    int result = solution[0];
	    
	    for(int i=1;i<solution.length;i++)
	    {
	    	if(result < solution[i])
	    	{
	    		  result = solution[i];
	    	}
	    }
		
	    return result;
	}

}
