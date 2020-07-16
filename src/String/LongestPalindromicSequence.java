package String;


//Memory: O(N^2)
//Space : O(1)
public class LongestPalindromicSequence {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "LPSASAPAAL";
		int sequence = lps(str,0,str.length()-1);
		System.out.print(sequence);

	}
	
	
	// Returns the length of the longest palindromic subsequence in seq
	static int lps(String strseq, int i, int j)
	{
		char[] seq = strseq.toCharArray();
	   // Base Case 1: If there is only 1 character
	   if (i == j)
	     return 1;
	 
	   // Base Case 2: If there are only 2 characters and both are same
	   if (seq[i] == seq[j] && i + 1 == j)
	     return 2;
	 
	   // If the first and last characters match
	   if (seq[i] == seq[j])
	   {
		  //System.out.println(strseq.substring(i,j));
	      return lps (seq.toString(), i+1, j-1) + 2;
	   }
	 
	   // If the first and last characters do not match
	   return Math.max( lps(seq.toString(), i, j-1), lps(seq.toString(), i+1, j) );
	}
	
	public static String FindLargestPalindrome(String input)
	{
		//handle input
		if(input.length() == 0)
		{
			return null;
		}
		
		if(input.length() == 0)
		{
			return input;
		}
		

		String longest = input.substring(0,1);
		
		//start scanning from mid for even sequence
		for(int i=0;i<input.length();i++)
		{
			String temp = helper(input, i, i);
			if(temp.length() > longest.length())
			{
				longest = temp;
			}
		}
		
		//start scanning from mid for odd sequence
		for(int i=0;i<input.length();i++)
		{
			String temp = helper(input, i, i+1);
			if(temp.length() > longest.length())
			{
				longest = temp;
			}
		}
		
		return longest;
		
	}

	
	private static String helper(String s, int start, int end)
	{
		while(start >= 0 && end <= s.length()-1 && s.charAt(start)== s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);
	}

}
