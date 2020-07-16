package ArrayQuestions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

	  LinkedList<Integer> queue;
	  int size;
	  double avg;
	  
	  public MovingAverage(int size) {
	        this.queue = new LinkedList<Integer>();
	        this.size = size;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[]{1,3,4,8,2,5,6,11};
		int[] result = MaxSlidingWindow(arr,2);
		System.out.print(Arrays.toString(result));

	}
	
	
	
	public static int[] MaxSlidingWindow(int[] nums, int k)
	{
		
		  if(nums==null||nums.length==0)
		        return new int[0];
		 
		    int[] result = new int[nums.length-k+1];
		 
		    LinkedList<Integer> deque = new LinkedList<Integer>();
		    for(int i=0; i<nums.length; i++){
		        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
		            deque.poll();
		 
		        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
		            deque.removeLast();
		        }    
		 
		        deque.offer(i);
		 
		        if(i+1>=k)
		            result[i+1-k]=nums[deque.peek()];
		    }
		 
		    return result;
		
		
		
	}
	
	public double FindAverage(int val)
	{
		
		if(queue.size() < this.size)
		{
			queue.offer(val);
			int sum = 0;
			for(int i : queue)
			{
				sum+= i;
				
			}
			avg = sum / queue.size();
			return avg;
		}
		else
		{
			
			int head = queue.poll();
			double minus = (double) head / queue.size();
			queue.offer(val);
			double add = (double) val / queue.size();
			avg = avg + add - minus;
			return avg;
		}
		
		
	}
	
	

}
