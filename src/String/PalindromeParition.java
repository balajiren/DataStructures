package String;
import java.util.*;

public class PalindromeParition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result)
	{
		if(start == s.length())
		{
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
			
		}
		
		for(int i=start+1;i<=s.length();i++)
		{
			String str = s.substring(start,i);
			if(Ispalindrome(str))
			{
				partition.add(str);
				addPalindrome( s, i, partition, result);
				partition.remove(partition.size()-1);
			}

			
		}
		
	}
	
	public boolean Ispalindrome(String s)
	{
		int start = 0;
		int end = s.length()-1;
		while(start < end)
		{
			if(s.charAt(start) != s.charAt(end))
			{
				return false;
			} 
			start++;
			end--;
		}
		return true;
	}

}
