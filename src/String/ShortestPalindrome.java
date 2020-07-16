package String;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  String res = shortestPalindrome_NSQUARED("abcd");
	  System.out.println(res);
	}
	
	 public static String shortestPalindrome_NSQUARED(String s) {
	        int i=0; 
	        int j=s.length()-1;

	        while(j>=0){
	            if(s.charAt(i)==s.charAt(j)){
	                i++;
	            }
	            j--;
	        }

	        if(i==s.length())
	            return s;

	        String suffix = s.substring(i);
	        String prefix = new StringBuilder(suffix).reverse().toString();
	        String mid = shortestPalindrome_NSQUARED(s.substring(0, i));
	        return prefix+mid+suffix;
	    }
	


}
