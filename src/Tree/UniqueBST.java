package Tree;

import java.util.ArrayList;
import java.util.*;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //left node - i right node => n-i-1
	private int helper(int n, int [] dp){

		/* base case when no element than bst is null(though it is 0 but we count as 1 since at end we do combination in left* combinations in right )also bst with one node is 1*/
		if(n==0 || n==1)
			return 1;

		int combinations = 0;
		for(int i=0;i<n;i++){

			/* no of elements in the left tree */
			if(dp[i]==-1)
				dp[i] = helper(i,dp);

			/* no of elements in the right tree */
			if(dp[n-1-i]==-1)
				dp[n-i-1] = helper(n-i-1,dp);

			combinations += dp[i]*dp[n-i-1];

		}
		return combinations;

	}

	public int numTrees(int n) {

		int [] dp = new int[n];
		Arrays.fill(dp,-1);
		return helper(n,dp);
	}



	public List<TreeNode> generateTrees(int n) {
	    if(n==0){
	        return new ArrayList<TreeNode>();
	    }
	 
	    return helper(1, n);
	}
	 
	public List<TreeNode> helper(int m, int n){
	    List<TreeNode> result = new ArrayList<TreeNode>();
	    if(m>n){
	        result.add(null);
	        return result;
	    }
	 
	    for(int i=m; i<=n; i++){
	        List<TreeNode> ls = helper(m, i-1);
	        List<TreeNode> rs = helper(i+1, n);
	        for(TreeNode l: ls){
	            for(TreeNode r: rs){
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                result.add(curr);
	            }
	        }
	    }
	 
	    return result;
	}

}
