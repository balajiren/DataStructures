package String;

import java.util.*;

public class CrackSafe {
	
	  Set<String> seen;
	  StringBuilder ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String crackSafe(int n, int k) {
		 
		 if (n == 1 && k == 1) return "0";
	        seen= new HashSet();
	        ans = new StringBuilder();

	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < n-1; ++i) {
	        	sb.append("0");
	        }
	        String start = sb.toString();
	        dfs(start,k);
	        ans.append(start);
	        return new String(ans);
	 }
	 
	    public void dfs(String node, int k) {
	  
	    	for(int x=0;x<k;x++) {
	    		  String nei = node + x;
	    		  if(!seen.contains(x)) {
	    			  seen.add(nei);
	    			  dfs(nei.substring(1),x);
	    			  ans.append(x);
	    		  }
	    		
	    		
	    	}
	    	
	    	
	    	
	    }

}
