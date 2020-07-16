package ArrayQuestions;

public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{4,-1,2,1};
		int result = FindMAXContiguousSubArray(input);
		System.out.print(result);

	}
	
	public static int FindMAXContiguousSubArray(int[] nums)
	{
		int[] res = new int[nums.length];
		int result = nums[0];
		int maxresult = nums[0];
		
		for(int i=1;i<nums.length;i++)
		{
			result = Math.max(nums[i],nums[i] + result);
			maxresult  = Math.max(maxresult,  result);
			
		}
		
		
		return result;
	}
	
	

}
