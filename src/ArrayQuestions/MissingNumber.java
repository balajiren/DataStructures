package ArrayQuestions;
import java.util.*;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = missingNumber(new int[]{1,2,0,3,6});
        System.out.println(res);
	}
	
	public static int missingNumber(int[] nums) {
		   Arrays.sort(nums);
		   int l=0, r=nums.length;
		   while(l<r){
		       int m = (l+r)/2;
		       if(nums[m] > m)
		       {
		    	   r = m;
		       } else
		       {
		    	   l = m+1;
		       }
		     
		   }
		 
		   return r;
		}

	
	 public static int firstMissingPositive(int[] nums) {
	        int missing = Integer.MAX_VALUE;
	        if(nums.length == 0) { return 1; }
	        Set<Integer> numSet = new HashSet<Integer>();
	        for(int i : nums) {
	            if(!numSet.contains(i) && i >= 0) {
	                numSet.add(i);
	                
	            }
	            
	        } 
	        if(numSet.size() == 1 && !numSet.contains(1)) {
	            return 1;
	        }
            int min = Integer.MAX_VALUE;
	         for(int i : nums) {

	                if(i > 1 && (!numSet.contains(i-1))) {
	                    min =Math.min(min,i-1); 
	                    

	                }
	              
	                if(i >= 0 && (!numSet.contains(i+1))) {
	                         min = Math.min(min,i+1);
	                         

	                    }
	                  missing = Math.min(min,missing);
	                 
	                }
	        

	     return  missing;
	        
	    }
	 
	 int firstMissingPositiveAnd0(int A[]) {
			int n = A.length;
			for (int i = 0; i < n; i++) {
				// when the ith element is not i
				while (A[i] != i) {
					// no need to swap when ith element is out of range [0,n]
					if (A[i] < 0 || A[i] >= n)
						break;
		 
					//handle duplicate elements
					if(A[i]==A[A[i]])
		                    		break;
					// swap elements
					int temp = A[i];
					A[i] = A[temp];
					A[temp] = temp;
				}
			}
		 
			for (int i = 0; i < n; i++) {
				if (A[i] != i)
					return i;
			}
		 
			return n;
		}

	 
	 public int missingElement_1(int[] nums, int k) {
	        int n = nums.length;
	        int left = 0;
	        int right = n-1;
			// Maintain a window [left, right] where left < right
			// for a middle point where mid > left, 
			// count the missing elements between left and mid,
			// if the count >= k, move right to mid-1
			// else subtract k with count and move left to mid
			// the Kth missing element will always be nums[left]+k
	        while (left < right) {
	            int mid = left + (right-left)/2;
	            if (mid == left) {
	                mid++;
	            }
	            int leftCount = nums[mid]-nums[left]-(mid-left);
	            if (leftCount >= k) {
	                right = mid-1;
	            } else {
	                k -= leftCount;
	                left = mid;
	            }
	        }
	        return nums[left]+k;
	    }

}
