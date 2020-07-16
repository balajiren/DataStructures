package Number;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionsOfNumber {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1,2,3};
		permute(input);

	}
	
	public static void permute (int[] n)
	{
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n.length == 0) {
			
		}
	    Permute(n, 0, result);
	    for(ArrayList<Integer> i : result)
	    {
	    	StringBuilder sb = new StringBuilder();
	    	for (Integer s : i)
	    	{
	    	    sb.append(s);
	    	}
	    	System.out.println(sb.toString() + "\n");
	    }
		
		
		
		
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	public static void Permute(int[] source,int start, ArrayList<ArrayList<Integer>> result)
	{
		if(start >= source.length)
		{
			ArrayList<Integer> val = convertArrayToList(source);
			result.add(val);
			
		}
		
	   for(int j=start; j < source.length; j++)
	   {
		   swap(source, start,j);
		   Permute(source, start+1,result); 
		   swap(source, start,j);
		   
	   }
		
	}

}
