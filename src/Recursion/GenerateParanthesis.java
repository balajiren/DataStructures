package Recursion;

import java.util.ArrayList;

public class GenerateParanthesis {

	public static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	 
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	 
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  ArrayList<String> result = new ArrayList<String>();
		  dfs(result, "", 3, 3);
		  System.out.print(result);
		   
		   
	}

}
