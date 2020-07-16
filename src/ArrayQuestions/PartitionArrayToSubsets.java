package ArrayQuestions;

import java.util.Arrays;

public class PartitionArrayToSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
	       int sum = 0;
	        for(int num: nums){
	            sum+=num;
	        }
	        if(sum%k!=0){
	            return false;
	        }

	        int share = sum/k;

	        //sort array
	        Arrays.sort(nums);

	        int j=nums.length-1;
	        if(nums[j]>share){
	            return false;
	        }
	        while(j>=0 && nums[j]==share){
	            j--;
	            k--;
	        }

	        int[] buckets = new int[k];
	        return helper(j, nums, share, buckets);
	    }
	    
	    public boolean helper(int j, int[] nums, int share, int[] buckets){
	    if(j<0){
	        return true;
	    }
	 
	    for(int i=0; i<buckets.length; i++){
	        if(buckets[i]+nums[j]<=share){
	            buckets[i]+=nums[j];
	            if(helper(j-1, nums, share, buckets)){
	                return true;
	            }
	            buckets[i]-=nums[j];
	        }
	 
	        if(buckets[i]==0)  break;//
	    }
	 
	    return false;
	}

}
