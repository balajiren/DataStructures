package String;

public class GameOfThrone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean result = IsPalindrome("bbaaabb");
		System.out.println(result);

	}
	
	public boolean IsAnagramPalindrome(String s)
	{
		int oddCount = 0;
		int[] lettercount = new int[26];
		for(int i=0;i<s.length();i++)
		{
			Character c = s.charAt(i);
			lettercount[c-'a']++;
			
		}
		int counter = 1;
		for(int i : lettercount)
		{
			if(i%2 == 1)
			{
				counter = 1;
			}
			if(counter > 1)
			{
				return false;
			}
		}
			
		return true;
		
	}
	
	public static boolean IsPalindrome(String s)
	{

		int mid = 0;
		if(s.length()%2 == 0)
		{
			mid = s.length() + 1 / 2;
		} else
		{
			mid = s.length() / 2;
		}
	
		int l = mid-1;
		int r = mid+1;
		while(l >=0 && r < s.length()-1)
		{
			if(s.charAt(l) != s.charAt(r))
			{
				return false;
			}
			l--;
			r++;
		}
		if(l !=0 || r !=s.length()-1)
		{
			return false;
		}
		
		return true;
	}

}
