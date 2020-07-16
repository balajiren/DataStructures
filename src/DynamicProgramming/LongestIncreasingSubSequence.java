package DynamicProgramming;
import java.util.*;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public int lengthOfLIS(int[] nums) {
	    int[] dp = new int[nums.length];
	    int len = 0; // len of sequence
	 
	    for(int num: nums){
	        int idx = Arrays.binarySearch(dp, 0, len, num);
	 
	        //if not found, return binarySearch return -insertPosition-1
	        if(idx < 0){
	            idx = - (idx + 1);
	        }
	 
	        dp[idx] = num;
	 
	        //update len when insert position is at the end
	        if(idx==len){
	            len++;
	        }
	    }
	 
	    return len;
	}
	
	public int LIS1(int[] nums)
	{
		int[] max = new int[nums.length];
		int maxlen= 0;
		for(int i=0;i<nums.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(nums[i] < nums[j])
				{
					max[i] = Math.max(max[i], max[j]+1);
				}
				
				
			}
			
			maxlen = Math.max(maxlen, max[i]);
		}
		return maxlen;
		
		
	}

}
