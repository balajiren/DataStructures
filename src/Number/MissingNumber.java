package Number;

import java.util.HashSet;
import java.util.Iterator;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{0,1,3,4,5};
		int result = missingNumber1(input);
		System.out.println(result);
	}
	
	public static int FindDuplicateXOR(int[] input)
	{
		int sum= 0;
		int n = input.length;
		for(int i=0;i<n;i++)
		{
			sum = input[i] ^ sum ;
		}
		return sum;
		//System.out.println(n+(n+1)/2  - sum);
		
	}
	
	public static int missingNumber1(int[] nums) {
	    int sum=0;
	    for(int i=0; i<nums.length; i++){
	        sum+=nums[i];
	    }
	 
	    int n=nums.length;
	    return n*(n+1)/2-sum;
	}
	
	public static int missingNumber(int[] nums) {
		 int l = 0;
	     int r = nums.length;
		 while(l < r) 
		 {
			 int mid = (l+r) / 2 ;
			 if(nums[mid] > mid)
			 {
				 r = mid;
			 } else
			 {
				 l = mid + 1;
			 }
			 
			 
		 }
		 return r;
	}
	
	public static int FindDuplicateNumber(int[] A)
	{
		int x= 0;
		for(int i : A)
		{
			x = x ^ i;
		}
		return x;
	}

}
