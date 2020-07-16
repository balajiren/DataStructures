package Problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinMaxOfSubArrayKSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = new int[]{12, 1, 78, 90, 57, 89, 56};
		FindMinimumOptimized(input,3);
	}
	
	// 1,2,4,8,3,11,4,6,12
	// i = 0 
	
	//o(n * m)
	public static void FindMinimal(int[] input, int k)
	{
		PriorityQueue<Integer> output = new PriorityQueue<Integer>(k);
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		for(i=0 ; i< input.length ; i++)
		{
			for(int j = i ; j < i+k && j < input.length; j++)
			{
			   
				output.offer(input[j]);
	
			
			}
			result.add(output.peek());
			output.clear();
			
		}
		
		StringBuilder endresult = new StringBuilder();
		for(int val : result)
		{
		
		  endresult.append(val + ":");
		}
		
		System.out.println(endresult);
		
		
	}

	
	//O(n) using deque
	//http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
	public static void FindMinimumOptimized(int[] input, int k)
	{
		Deque<Integer> que = new LinkedList<Integer>();
		int i = 0;
		for(i= 0; i < k ; i++)
		{
		   while(!que.isEmpty() && input[i] >= input[que.size()])
		   {
			   que.removeLast();
			
		   }
		   que.addLast(input[i]);
		}
		
		for(; i< input.length ;i++)
		{
			while(!que.isEmpty()  && que.getFirst() < i - k)
			{
				que.removeFirst();
			}
			
			while(!que.isEmpty() && input[i] >= que.size())
			{
				que.removeLast();
				
			}
			que.addLast(input[i]);
		}
		if(!que.isEmpty())
		System.out.println(que.getFirst());
	}
}
