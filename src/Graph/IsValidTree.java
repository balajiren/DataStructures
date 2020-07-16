package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class IsValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean ValidTree(int n,int[][] edges)
	{
		
		if(edges.length == 0 || edges[0].length == 0)
		{
			return false;
			
		}
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> lst = new ArrayList<Integer>();
			map.put(i, lst);
		}
		for(int[] edge : edges)
		{
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		
		//BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		queue.offer(0);
		while(!queue.isEmpty())
		{
			Integer top = queue.poll();
			if(visited[top]) {
				return false;
			}
			visited[top] = true;

				for(int i : map.get(top))
				{
					if(!visited[i])
							{
						       queue.offer(i);
							}
				}
				
		}
		
		for(boolean b : visited)
		{
			if(!b) { 
				return false;}
		}
	
		
		
		return true;
		
	}

}
