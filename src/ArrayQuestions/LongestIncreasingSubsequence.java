package ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class LongestIncreasingSubsequence {
	
	//O(N) - Time complexity Space O(1)
	public int findLengthOfLCIS(int[] nums) {
	        int left = 0, ans=0;
	        for(int i=0;i< nums.length;i++) {
	            if(i > 0 && nums[i-1] >= nums[i]) {
	                left = i;
	            }
	            ans = Math.max(ans, i-left+1);
	            
	        }
	        return ans;
	        
     }

	public int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	    Arrays.fill(max, 1);
	 
	    int result = 1;
	    for(int i=0; i<nums.length; i++){
	        for(int j=0; j<i; j++){
	            if(nums[i]>nums[j]){
	                max[i]= Math.max(max[i], max[j]+1);
	 
	            }
	        }
	        result = Math.max(max[i], result);
	    }
	 
	   return result;
	}
 
    // Driver program to test above function
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 4, 7, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+
        		FindLongestSequenceBinarySearch(A));
    }

    //Length of LIS
	public int lengthOfLIS_Binary(int[] nums) {
		int[] dp = new int[nums.length];
		int len  = 0;
		for(int i=0;i<nums.length;i++) {
			int pos = Arrays.binarySearch(dp,0,len,nums[i]);
			if(pos < 0) {
				pos = -(pos+1);
			}
			dp[pos] = nums[i];
			if(pos == len) {
				len++;
			}
		}
		return len;
	}



    
    //Optimized instead of naive
    public static int FindLongestSequenceBinarySearch(int[] nums)
    {
    	List<Integer> res = new ArrayList<Integer>();
    	Map<Integer,Integer> s = new TreeMap<Integer,Integer>();
    	for(int num : nums)
    	{
    		if(res.size() == 0 || num > res.get(res.size()-1))
    		{
    			res.add(num);
    		}
    		int i = 0;
        	int j = res.size()-1;
    		while(i< j)
    		{
    			int mid = (i+j) / 2;
    			if(res.get(mid) < num)
    			{
    				i = mid + 1;
    			} else
    			{
    				j = mid;
    			}
   
    		}
			//replace last number great
    		res.set(j, num);
    		
    	}
    	return res.size();
    }
    
    
    
    public static String  FindLongestSequence(int[] nums)
    {
    	int[] max = new int[nums.length];
    	int result=1;
    	HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
    	for(int i = 0; i<nums.length;i++)
    	{
    		for(int j=0;j<i;j++)
    		{
    			if(nums[i] > nums[j])
    			{
    				max[i] = Math.max(max[i], max[j]+1);
    				map.put(max[i] , j);
    			}
    		}
    		
    		result = Math.max(max[i], result);
    		map.put(result,map.get(result));
    		
    	}
    	
    	return String.valueOf(map.get(result)) + ":" + String.valueOf(result);
    }

}
