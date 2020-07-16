package ArrayQuestions;

public class MinimumSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,3,1,2,4,3};
		System.out.print(FindMinSubArraySum(7, nums));

	}
	
	
	public static int FindMinSubArraySum(int s, int[] nums)
	{
		
		int start = 0;
		int end = 0;
		int tempsum = 0;
		int minlen = nums.length;
		
		while(start <= nums.length)
		{
			if(tempsum < s)
			{
				if(start == nums.length)
				{
					break;
				}
				tempsum +=nums[start];
				start++;

			}
			else
			{
				minlen = Math.min(minlen, start-end);
				tempsum -=nums[end];
				end++;

			}
		}
		return minlen;
		
	}

	
	public static int FindMinLength(int s, int[] nums)
	{
		
		int start=0;
		int end = 0;
		int sum =0;
		boolean exists = false;
		int length = nums.length;
		
		 if(nums==null || nums.length==1)
		        return 0;
		
		while(end <= nums.length)
		{
			if(sum >=s)
			{
				exists = true;
				
				 if(start==end-1){
		                return 1;
		            }
				
				length =  Math.min(end - start, length);
				sum = sum-nums[start];
				start++;
			}
			
			else
			{
				if(end == nums.length)
				{
					break;
				}
				sum = sum+nums[end];
				end++;
				
			}
			
		}
		
		if(exists)
		{
			return length;
		}
		else
		{
			return 0;
		}

		
	}
	
}
