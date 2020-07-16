package String;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSequence {

	public static void main(String args[])
	{
		int res =FindLongestCommonSequenceBinary(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(res);
		
	}
	
	
	
	public LongestIncreasingSequence() {
		// TODO Auto-generated constructor stub
		
	}
	
	  private static int FindLongestCommonSequence(int[] nums)
	    {
	        
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
	  
	  
	  private static int FindLongestCommonSequenceBinary(int[] nums)
	  {
		   if(nums==null || nums.length==0)
		        return 0;
		  

		   ArrayList<Integer> list = new ArrayList<Integer>(); 
		   for(int num : nums)
		   {
			   if(list.size() == 0 || num>list.get(list.size()-1))
			   {
			   list.add(num);
			   }
			   else
			   {
				   int i = 0;
				   int j = list.size()-1;
				   while(i< j)
				   {
					   int mid = (i+j) / 2;
	
					   if(list.get(mid) < num)
					   {
						   i = mid+1;
					   }
					   else
					   {
						   j = mid;
					   }
					   
					   
				   }
				   list.set(j, num);
			   }
	
			   
		   }
		   System.out.println(String.valueOf(list));
		  return list.size();
	  }
	    

}
