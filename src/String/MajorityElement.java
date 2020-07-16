package String;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,1,1,5,4,1};
		int out = findMajorityElement(nums,nums.length);
		System.out.print(out);
		
	
	}
	
	//1,3,1,4,3,5
	//11335
	
	public static int majorityElement(int[] nums) {
	    int result = nums[0], count = 1;
	 
	    for(int i = 1; i<nums.length; i++ ) {
	        if(count == 0){
	            result = i;
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	    
	    int numOccurance = 0;
	    for(int i=0;i<nums.length;i++)
	    {
	    	if(nums[i] == nums[result])
	    	{
	    		numOccurance++;
	    	}
	       
	        	 
	    }
	    if(numOccurance > (nums.length)/2)
        {
       	 return nums[result];
        }
        else
          return -1;
	 
	}
	
	static int findMajorityElement(int a[], int size){
		int candidate  = a[0];
		int count  = 1;
	 
		for(int i=1; i<size; i++){
			if(count == 0){
				//if count = 0, make current index as candidate
				candidate = i;
				count  = 1;
			}
			else {
				if(a[i] == candidate){
					//if e is same as candidate, increment count
					count++;
				}
				else 
				    //if e is different, decrement count
					count--;
			}
		}
	 
		int numOccurance = 0;
		for(int i=0; i<size; i++){
			if(a[i] == a[candidate]){
				numOccurance++;
			}
		}
	 
		if(numOccurance > size/2) return a[candidate];
		else return -1;
	}

}
