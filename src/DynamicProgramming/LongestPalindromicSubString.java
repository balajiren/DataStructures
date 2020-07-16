package DynamicProgramming;

public class LongestPalindromicSubString {
	
	public static void main(String[] args)
	{
		
		System.out.println(LongestPalindrome("ABABCDCBEBAZ"));
	}

//avbcrczcrc
public static String LongestPalindrome(String s)
{
	if (s.isEmpty()) {
		return null;
	}
 
	if (s.length() == 1) {
		return s;
	}
	String longest = s.substring(0, 1);
	for(int i=0; i< s.length();i++)
	{
	       String temp = helper(s,i,i);
	       if (temp.length() > longest.length()) {
				longest = temp;
			}
	       
	       temp = helper(s,i,i+1);
	       if (temp.length() > longest.length()) {
				longest = temp;
			}
			
	}
	
		return longest;
}

public static String helper(String str, int start, int end)
{
	while(start >=0 && end <=str.length()-1 && str.charAt(start) == str.charAt(end) )
	{
		start--;
		end++;
	}
	
	return str.substring(start+1, end);
	
	
}

}

