package Heap;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean CanAttendMeetings(Interval[] intervals)
	{
		
		Arrays.sort(intervals, new Comparator<Interval>()
		{
			public int compare(Interval i1,Interval i2)
			{
				return (int) (i1.start - i2.start);
			}
		});
		
		for(int i=0;i<intervals.length;i++)
		{
			if(intervals[i].end > intervals[i].start )
			{
				return false;
			}
		}
		return true;
	}

}
