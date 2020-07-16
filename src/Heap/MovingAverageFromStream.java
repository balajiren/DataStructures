package Heap;

import java.util.*;

public class MovingAverageFromStream {
	
	

	public int FindMovingAverage(int[] nums, int size)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		int avg = 0;
		for(int num : nums)
		{
			if(q.size() < size)
			{
				q.add(num);
				int sum = 0;
				for(int i : q)
				{
					sum+=i;
				}
				avg = sum / q.size();
				
			} else
			{
				
				int head = q.poll();
				int minus = head / size;
				q.offer(num);
				int add = num / size;
				 avg  = avg + add - minus;
				
				
			}
		}
		 return avg;
		
	}
	
	
	 /*public double next(int val) {
	        if(queue.size()<this.size){
	            queue.offer(val);
	            int sum=0;
	            for(int i: queue){
	                sum+=i;
	            }
	            avg = (double)sum/queue.size();
	 
	            return avg;
	        }else{
	            int head = queue.poll();
	            double minus = (double)head/this.size;
	            queue.offer(val);
	            double add = (double)val/this.size;
	            avg = avg + add - minus;
	            return avg;
	        }
	    } */

}
