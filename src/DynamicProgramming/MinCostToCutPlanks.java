package DynamicProgramming;

public class MinCostToCutPlanks {

	
	 public static void main(String[]args){
		    System.out.println(findMinCost(new int[]{1, 3, 7, 10}, 15));
		   // System.out.println(findMinCost(new int[]{}, 15));
		   // System.out.println(findMinCost(new int[]{1}, 15));
		   // System.out.println(findMinCost(new int[]{23, 34, 35, 68, 71, 88, 93}, 100));
		  }
		  private static int findMinCost(int[] markings, int len){
		    int[] logLen = logLen(markings, len);
		    int[][] dp = new int[markings.length+2][markings.length+2];
		    for(int betweenMarkCount = 1; betweenMarkCount <= markings.length; ++betweenMarkCount){
		      for(int i = 0;; ++i){
		        int j = i+betweenMarkCount+1;
		        if (j >= dp.length) break;
		        int min = Integer.MAX_VALUE;
		        int cost = logLen[j]-logLen[i];
		        for(int k = i+1; k <= j-1; ++k){
		          min = Math.min(min, dp[i][k]+dp[k][j]+cost);
		        }
		        dp[i][j] = min;
		      }
		    }
		    return dp[0][dp.length-1];
		  }
		  private static int[] logLen(int[] markings, int len){
		    int[] ret = new int[markings.length+2];
		    for(int i = 1; i <= markings.length; ++i){
		      ret[i] = markings[i-1];
		    }
		    ret[ret.length-1] = len;
		    return ret;
		  }

}
