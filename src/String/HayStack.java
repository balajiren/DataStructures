package String;

public class HayStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int strStr(String haystack, String needle) {
	        
			int N = needle.length(), h = haystack.length();
	        //n=10 //L =2 10-2+1 9 
	        
	        for(int start=0;start <  h - N + 1;start++ ) {
	            if(haystack.substring(start,start+N).equals(needle)) {
	                return start;
	            }
	        }
	       return -1;
	    }

}
