package String;

import java.util.HashMap;
import java.util.HashSet;

import Common.Utils;

public class LengthOfLongestSubString {

	public LengthOfLongestSubString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int result = LengthOfLongestSubString("abcabcbb");
		 System.out.print(result);
	}	
	

	public static int LengthOfLongestSubString(String s)
	{
		
		char[] arr= s.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i],i);
			}
			else
			{
				count = Math.max(count, map.size());
				map.clear();
			}
		}
		
		return Math.max(count, map.size());
		
		
		
	}

}
