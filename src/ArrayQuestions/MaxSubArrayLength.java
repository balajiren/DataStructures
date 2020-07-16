package ArrayQuestions;

public class MaxSubArrayLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, -1, 5, -2, 3};
		int result = MaxSubArrayLength(nums,3);
		System.out.println(result);

	}
	
	public static int MaxSubArrayLength(int[] nums, int t) {
		
		
		int maxlen=0;
		int start=0;
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			
			if(sum + nums[i] <= t) {
				sum+=nums[i];
				//length = Math.max(length,i-start);
			} else {
				sum-=nums[start]+ nums[i];
				start++;
			}
			maxlen = Math.max(i, maxlen);
			
			
			
		}
		
		
		return maxlen;
	}
	
	//Given nums = [1, -1, 5, -2, 3], k = 3,
	//start, end iterate nums until sum reaches and cache the sum
	//sliding window approach
	public static int FindMaxSubArrayLength(int[] nums, int target)
	{
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxlen = 0;
		while(j < nums.length)
		{
			if(sum + nums[j] <= target)
			{
				sum+=nums[j];
				i++;
			}
			else
			{
				sum= sum - nums[i] + nums[j];
			}
			maxlen = Math.max(i, maxlen);
			
			j++;
		}
		
		return maxlen;
	}
}
