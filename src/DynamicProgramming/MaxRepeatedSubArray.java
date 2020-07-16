package DynamicProgramming;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class MaxRepeatedSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int findLength(int[] A, int[] B) {
	        int ans = 0;
	        int[][] memo = new int[A.length + 1][B.length + 1];
	        for(int i= A.length-1;i>=0;i--) {
	            for(int j= B.length-1;j>=0;j--) {
	                if(A[i] == B[j]) {
	                memo[i][j] = memo[i+1][j+1]+1;
	                ans = Math.max(ans,memo[i][j]);
	                    
	                }
	            
	        }
	       
	    }
	          return ans;
	   }

}
