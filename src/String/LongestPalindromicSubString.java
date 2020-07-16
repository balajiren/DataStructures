package String;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String temp = ShortPalindrome("aacacaadf");
		System.out.println(temp);

	}
	
	public static String LongestPalindrome(String s)
	{
		
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0,1);
		for(int i=0; i<s.length();i++)
		{
			String temp = longesthelper(s, i, i);
			longest = temp.length() > longest.length() ? temp : longest;
			
			 temp = longesthelper(s, i, i+1);
			longest = temp.length() > longest.length() ? temp : longest;
			
				
						
		}
		return longest;
		
	}
	
	public static String ShortPalindrome(String s)
	{
		
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0,1);
		for(int i=0; i<s.length();i++)
		{
			String temp = longesthelper(s, i, i);
			longest = temp.length() < longest.length() ? temp : longest;
			
			 temp = longesthelper(s, i, i+1);
			longest = temp.length() < longest.length() ? temp : longest;
			
				
						
		}
		return longest;
		
	}
	
//	public String shortestPalindrome(String s) {
//	    int i=0; 
//	    int j=s.length()-1;
//	 
//	    while(j>=0){
//	        if(s.charAt(i)==s.charAt(j)){
//	            i++;
//	        }
//	        j--;
//	    }
//	 
//	    if(i==s.length())
//	        return s;
//	 
//	    String suffix = s.substring(i);
//	    String prefix = new StringBuilder(suffix).reverse().toString();
//	    String mid = shortestPalindrome(s.substring(0, i));
//	    return prefix+mid+suffix;
//	}
	
	
	public static String longesthelper(String s, int begin , int end)
	{
		
		while(begin >=0  && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end))
		{
			begin --;
			end++;
			
		}
		return s.substring(begin+1, end);
		
	}

}
