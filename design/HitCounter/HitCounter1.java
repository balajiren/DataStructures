package HitCounter;

import java.util.*;

import HitCounter.HitCounter.TimeSlot;

public class HitCounter1 {
	
	Queue<Integer> que;
	 // private Deque<TimeSlot> slots = new ArrayDeque<>(WINDOW_SIZE * 60);
	
	public  HitCounter1()
	{
		que = new LinkedList<Integer>();
	}
	
	public void increaseHits(int timestamp)
	{
		que.offer(timestamp);
	}
	public long getHits(int timestamp)
	{
		while(!que.isEmpty() && timestamp-que.poll() > 300)
		{
			que.poll();
		}
		return que.size();
	}

}
