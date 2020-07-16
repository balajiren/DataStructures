package String;

import java.util.Stack;

public class CheckStringIsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean IsPalindrome(String s) {

      for(int i=0,j=s.length()-1;i<j;i++,j--) {

      	while(i<j && !Character.isLetterOrDigit(s.charAt(i))) {
      		i++;

		}
		while(i<j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;

		}

	    if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
	    	return false;
		}
	    i++;
	    j--;

      }
      return true;
	}
	
	
	public boolean CheckPalindrome(String s)
	{
		
		s.replaceAll("[^a-zA-Z0-9]", "");
		char[] arr = s.toCharArray();
		Stack<Character> st = new Stack<Character>();
		
		int index = 0;
		
		while(index < arr.length /2 )
		{
			st.push(s.charAt(index));
			index++;
		}
		
		while(index < s.length())
		{
			char c = st.pop();
			if(s.charAt(index) != c)
			{
				return false;
			}
			index++;
			
		}
		return true;
	}

}
