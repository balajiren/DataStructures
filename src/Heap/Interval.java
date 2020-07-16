package Heap;

import java.util.Date;

public class Interval {
	
	public long startTime;
	public long start;
	public void SetStartTime(Date time) 
	{
		//start.getTime();
		start = time.getTime();
	}
	public long GetStartTime() 
	{
		return start;
	}
	public int end;
	public String Name;

}
