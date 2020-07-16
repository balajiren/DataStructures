package ArrayQuestions;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[]{2,3,1,2,4,3};
		System.out.print(MinSubArraySum(nums, 7));
	}
	
	public static int MinSubArraySum(int[] nums, int sum) {
		
		int start = 0;
		int minsum = 0;
		int result = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			
			minsum+=nums[i];
			while(minsum>=sum) {
				result = Math.min(result, i+1-start);
				minsum-=nums[start++];
			}
			
			
			
		}
		
		return result!=Integer.MAX_VALUE?result:0;
		
		
		
	}
	
	
	public static int MinSizeSubArrayLen(int s, int[] nums)
	{
		int minlen =  Integer.MAX_VALUE;
		
		int start = 0;
		int sum= 0;
		
		for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            while(sum >=s) {
                minlen = Math.min(minlen,i+1-start);
                sum-=nums[start++];
            
            }
            
            
        }
		
		return minlen!=Integer.MAX_VALUE?minlen:0;
		
	}
	
}


