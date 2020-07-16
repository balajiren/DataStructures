package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int FindMinMeetingRooms(Interval[] intervals)
	{
		
		PriorityQueue<Integer> queue = new	PriorityQueue<Integer>();
		
		Arrays.sort(intervals, new Comparator<Interval>()
		{
			
			public int compare(Interval i1, Interval i2)
			{
				return  ((int) i1.start - (int)i2.start);
			}
			
			
		});
        int count=1;
		queue.offer(intervals[0].end);
		for(int i=1;i<intervals.length;i++)
		{
			if(intervals[i].start < queue.peek()){
				count++;
			}
			else
			{
				queue.poll();
			}
			queue.offer(intervals[i].end);
		}
		
		return count;
	}

}
