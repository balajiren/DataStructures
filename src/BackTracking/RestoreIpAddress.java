package BackTracking;
import java.util.*;

public class RestoreIpAddress {
	
	  int n;
	  String s;
	  LinkedList<String> segments = new LinkedList<String>();
	  ArrayList<String> output = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> RestoreIpAddress(String s) {
		
		int n = s.length();
		this.s = s;
		backtrack(-1,3);
		return output;
		
		
	}
	
	public boolean valid(String segment) {
	    /*
	    Check if the current segment is valid :
	    1. less or equal to 255      
	    2. the first character could be '0' 
	    only if the segment is equal to '0'
	    */
	    int m = segment.length();
	    if (m > 3)
	      return false;
	    return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
	  }
	
	
	 public void update_output(int curr_pos) {
		 
		 String segment = s.substring(curr_pos+1,n);
		 if(valid(segment)) {
			 this.segments.add(segment);
			 output.add(String.join(".", segments));
			 segments.removeLast();
		 }
		 
	 }
	
	//place dots after 1 digit, 2 digit or 3 digits . So 3*3 = 27
	public void backtrack(int prev_pos, int dots) {
		int max_pos = Math.max(n-1, prev_pos+4);
		for(int curr_pos=prev_pos+1;curr_pos<max_pos;curr_pos++) {
			
			String segment = s.substring(prev_pos+1,curr_pos+1);
			segments.add(segment);
			if(dots-1 ==0) {
				update_output(curr_pos); 
				//update output
			} else {
				backtrack(curr_pos,dots-1);
				
			}
			segments.removeLast();
		}
		
		
	}
	

}
