package ArrayQuestions;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public MergeInterval() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> lst = new ArrayList<Interval>();
		lst.add(new Interval(1, 3));
		lst.add(new Interval(2, 6));
		lst.add(new Interval(8, 10));
		merge(lst);

	}
	
	

    public int[][] merge(int[][] size) {

        //sort by start time
        //if end time is greater than next start then merge
        Collections.sort(Arrays.asList(size),new Comparator<int[]>() {
           
            @Override
            public int compare(int[] i1, int[] i2) {
               if(i1[0] < i2[0]) {
                   return -1;
               } else
               if(i1[0] ==  i2[0]) {
                   return 0;
               }  else {
                   return 1;
               }
            }
            
        });
         LinkedList<int[]> merged = new LinkedList<>();
         for (int[] interval : size) {
              if (merged.isEmpty() || merged.getLast()[1] < interval[0])                {
                    merged.add(interval);
               } else {
              	  //// otherwise, there is overlap, so we merge the current and previous
				  //      // intervals.
                  merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                  
              }
              
              
          }
       
        return merged.toArray(new int[merged.size()][]);
    }
	
	
	public static List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start_time!=i2.start_time)
	                return i1.start_time-i2.start_time;
	            else
	                return i1.end_time-i2.end_time;
	        }
	    });
	 
	    Interval pre = intervals.get(0);
	    for(int i=0; i<intervals.size(); i++){
	        Interval curr = intervals.get(i);
	        if(curr.start_time>pre.end_time){
	            result.add(pre);
	            pre = curr;
	        }else{
	            Interval merged = new Interval(pre.start_time, Math.max(pre.end_time, curr.end_time));
	            pre = merged;
	        }
	    }
	    result.add(pre);
	 
	    return result;
	}
	

}
