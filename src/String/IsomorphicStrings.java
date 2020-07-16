package String;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean IsIsomorphicStrings(String s1, String s2)
	{
		if(s1==null || s2 ==null)
		{
			return false;
			
		}
		
		HashMap<Character,Character> ismap = new HashMap<Character,Character>();
		for(int i=0;i<s1.length();i++)
		{
			
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if(ismap.containsKey(c1))
			{
				if(ismap.get(c1)!=c2)
				{
					return false;
				}
			}
			else
			{
				if(ismap.containsKey(c2)){
					return false;
				}
				
			}
					
			
			ismap.put(c1, c2);
			
			
		}
		
		return true;
		
	}

}
