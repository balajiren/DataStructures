package ArrayQuestions;
//https://leetcode.com/problems/find-pivot-index/submissions/

public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int pivotIndex(int[] nums) {
	      
	        int sum=0, leftsum=0;
	        for(int num : nums) {
	            sum+=num;
	        }
	        for(int i=0;i<nums.length;i++) {
	            if(leftsum == sum-leftsum-nums[i]) {
	                return i;
	            }
	            leftsum+=nums[i];
	        }
	        return -1;
	    }

}
