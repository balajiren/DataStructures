package ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Array3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{-1,2,1,-4,16,13,18};
		//int[] result = twoSum(input,19);
		int res = Find3SumClosest(input,15);
		System.out.println(res);
		/*for(int i : result)
		{
			System.out.print(i+"\n");
		} */

	}
	//map heap => collections.reverseOrder
	
	public static int[] FindPairOfNumbers(int[] arrInput, int target)
	{
	    int[] result = new int[2];
	    HashMap<Integer,Integer> map = new  HashMap<Integer,Integer>();
	    int index = 0;
	    for(int num : arrInput)
	    {
	        // if map not contains add the delta
	        if(!map.containsKey(num))
	        {
	            map.put(target - num,index);
	            
	        }
	        // if delta element is present in the map
	        else
	        {
	            int num1Index = (Integer) map.get(num);
	            if(num1Index > -1)
	            {
	             result[0] = num1Index;
	             result[1] = index;
	             break;
	            }
	        }
	        
	        index ++;
	        
	        
	    }
	    return result;
	 
	}

	public static int[] FindTwoSum(int[] nums, int target) {

		HashMap<Integer,Integer> map = new HashMap<>();
		int[] res = new int[2];
		for(int n : nums) {
			if(map.containsKey(n)) {
				res[0] = n;
				res[1] = map.get(n);
				break;
			}
			map.put(target-n, n);
		}

		return res;


	}
	
	// { 2, 3, 2} target = 5
	public static int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		for(int i : nums)
		{
			if(m.containsKey(i))
			{
				 result[0] = m.get(i);
				 result[1] = i;
				 break;
			}
			m.put(target-i, i);
		}
		return result;
	}
	
	
	//array must be sorted
	public List<List<Integer>> threeSum(int[] num)
	{
		  Arrays.sort(num);
		  
		
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		 //base condition
		 if(num == null || num.length < 3)
		 {
			 return result;
		 }
		 
		 for(int i=0;i<num.length-2;i++)
		 {
			 
			if(i==0 || num[i] > num[i-1])
			{
				
			   int j =i+1;
			   
			   int k = num.length - 1;
			   
			   
			   while(j < k)
			   {
				   if(num[i] + num[j]+ num[k] == 0)
				   {
					   List<Integer> l = new ArrayList<Integer>();
	                    l.add(num[i]);
	                    l.add(num[j]);
	                    l.add(num[k]);
	                    result.add(l);
	                    
	                    j++;
	                    k--;
	                    
	                    //handle duplicates
	                    while(j < k && num[j] == num[j-1])
	                    {
	                    	
	                    	j++;
	                    }
	                    
	                    while(j < k && num[j] == num[j-1])
	                    {
	                    	
	                    	k--;
	                    }
				    } 
					   else if(num[i] + num[j]+ num[k] < 0)
	                   {
	                   	 j++;
	                   }
					   else
					   {
						   k--;
					   }
				   }
				   
				   
			   }
				
				
				
			}
	
		return result;
	}
	
	
	
	public static int Find3SumClosest(int[] nums, int target) {
	    int min = Integer.MAX_VALUE;
		int result = 0;
	 
		Arrays.sort(nums);
	 
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(sum - target);
	 
				if(diff == 0) return sum;
	 
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
	 
		return result;
	}
	
	/**
	 * 
	 * @param input
	 * @param target
	 * @return
	 */
	//Time Complexity is O(n^2).
	public static int Find3SumClosest1(int[] input, int target)
	{
		if(input.length == 1)
		{
			return input[0];
		}
	    Arrays.sort(input);
		int closest = input[0]+input[1]+input[2];
		int diff = target - closest;
		int start = input[0];
		int end = input.length - 1;
		
		   for(int i=0;i<input.length - 2;i++)
		   {
			  while(start < end)
			 {
				  int sum = input[i]+input[i+1]+input[end];
				  int newdiff = target - sum;
				  if(newdiff == 0)
				  {
					  return closest;
				  }
				  if(newdiff < diff)
				  {
					  newdiff = diff;
					  closest = sum;
				  }
				  if(sum < target)
				  {
					  start++;
				  }
				  else
				  {
					  end--;
				  }
			 }
		   			
		}
		   return closest;
		
		
	}
	
	//Time is N to the power of (k-1).
	public List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums==null|| nums.length<4)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-3; i++){
	        if(i!=0 && nums[i]==nums[i-1])
	            continue;
	        for(int j=i+1; j<nums.length-2; j++){
	            if(j!=i+1 && nums[j]==nums[j-1])
	                continue;
	            int k=j+1;
	            int l=nums.length-1;
	            while(k<l){
	                if(nums[i]+nums[j]+nums[k]+nums[l]<target){
	                    k++;
	                }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
	                    l--;
	                }else{
	                    List<Integer> t = new ArrayList<Integer>();
	                    t.add(nums[i]);
	                    t.add(nums[j]);
	                    t.add(nums[k]);
	                    t.add(nums[l]);
	                    result.add(t);
	 
	                    k++;
	                    l--;
	 
	                    while(k<l &&nums[l]==nums[l+1] ){
	                        l--;
	                    }
	 
	                    while(k<l &&nums[k]==nums[k-1]){
	                        k++;
	                    }
	                }
	 
	 
	            }
	        }
	    }
	 
	    return result;
	}

}
