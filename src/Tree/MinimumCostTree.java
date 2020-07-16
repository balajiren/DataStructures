package Tree;

public class MinimumCostTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        
        return dpHelper(arr, 0, arr.length - 1, dp);
    }
    
    public int dpHelper(int[] arr, int start, int end, int[][] dp) {
        if (start == end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        
        int interval = end - start;
        int count = Integer.MAX_VALUE;
        
        for (int i = 0; i < interval; i++) {
            int countLeft = dpHelper(arr, start, start + i, dp);
            int countRight = dpHelper(arr, start + i + 1, end, dp);
            int curMax = getMax(arr, start, start + i) * getMax(arr, start + i + 1, end);
            
            count = Math.min(countLeft + countRight + curMax, count);
        }
        
        dp[start][end] = count;
        return count;
    }
    
    public int getMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        
        int maxV = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            maxV = Math.max(maxV, arr[i]);
        }
        
        return maxV;
    }

}
