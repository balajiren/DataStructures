package ArrayQuestions;

public class ContigiousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrA = { 25, 12, 14, 22, 19, 15, 10, 23 };
		int Sum = 55;
		SubArray(arrA,Sum);

	}
	
	
	public static void SubArray(int[] nums, int sum)
	{
		int tsum =0;
		int start = 0;
		
		for(int i=0;i<nums.length;i++)
		{
			
			while(tsum > sum)
			{
				tsum -= nums[start];
				start++;
			}
			
			if(tsum == sum)
			{
				System.out.print(sum + " is found between indexes " + start
				+ " and " + (i - 1));
				
				for(int j=start;j<=i-1;j++)
				{
					System.out.print(" " + nums[j]);
				}
				
			}
			
			
			if(i < nums.length)
			{
				tsum+=nums[i];
			}
			
			
			
		}
		
		
		
		
	}

}
