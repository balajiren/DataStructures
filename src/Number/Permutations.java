package Number;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		p.FindNthCombinations(4, 2);

	}
	
	
	
	public void FindNthCombinations(int n, int k)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n,k,0,item,result);
		
		
		
	}
	
	
	public void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result)
	{
		if(item.size() == k)
		{
			System.out.println(Arrays.toString(item.toArray()));
			result.add(item);
			return;
		}
		for(int i=start;i<n;i++)
		{
			item.add(i);
			dfs(n,k,start+1,item,result);
			item.remove(item.size()-1);
		}
		
	}
		

}
