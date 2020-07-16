package ArrayQuestions;
import java.util.*;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	
//	Add to the output all the intervals starting before newInterval.
//
//	Add to the output newInterval. Merge it with the last added interval if newInterval starts before the last added interval.
//
//	Add the next intervals one by one. Merge with the last added interval if the current interval starts before the last added interval.
	 public int[][] insert(int[][] intervals, int[] toInsert) {
	     
		    if(intervals.length == 0 && toInsert.length==0) {
				        return intervals;
			}
		     List<int[]> result = new ArrayList<>();
		     int[] curr = toInsert;
		     
		     for(int[] interval : intervals)  {
		         
		         //no overlap
		         if(curr[0] > interval[1] || curr[1]  < interval[0]) {
		             if(curr[0] > interval[1]) {
		                 result.add(interval);
		             } else {
		                 result.add(curr);
		                 curr = interval;
		             }
		             
		         } else {
		             curr = new int[]{Math.min(curr[0],interval[0]), Math.max(curr[1],interval[1])};
		         }
		         

		     }
		        result.add(curr);
			    return result.toArray(new int[0][0]); 
		        
		    }
	
}
