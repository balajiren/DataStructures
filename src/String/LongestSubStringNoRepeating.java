package String;
import java.util.*;

public class LongestSubStringNoRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = LongestSubStringNonRepeat("bbbbb");
		System.out.println(res);

	}
	
	
	public int lengthOfLongestSubstring(String s) {
	     int n = s.length();
	     Set<Character> set = new HashSet<>();
	     int ans = 0, i = 0, j = 0;
	     while(i<n && j < n) {
	        if(!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j));
	            j++;
	            ans = Math.max(j-i,ans);
	        } else {
	            set.remove(s.charAt(i));
	            i++;
	        }
	         
	         
	     }
	     return ans;
	        
	    }
	
	//add chars to map with count
	//if count more than 1 remove the character and calculatr max size
	// return global max size
	//bbbbb
	public static int LongestSubStringNonRepeat(String input)
	{
		HashSet<Character> map = new HashSet<Character>();
		int maxSize = 0;
		int k = 0;
		StringBuilder s = new StringBuilder();

		
		for(int i=0;i<input.length();i++)
		{
			Character c = input.charAt(i);
			if(!map.contains(c))
			{
				map.add(c);
				s.append(c.toString());
				maxSize = Math.max(map.size(), maxSize);
			}
			else
			{
				while(k < i)
				{
					//if current character = start counter then dup
					if(c == input.charAt(k))
					{ 
						k++;
						break;
						
					} else
					{
						map.remove(input.charAt(k));
						//s.deleteCharAt(k);
						k++;
					}
					
					
				}
				
				
				
			}

			
		}
		System.out.println(s.toString());
		return maxSize;
	}
	
	
	public static int LongestStringNonRepeating3(String input)
	{
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		int result = 0;
		int k = 0;
		
		for(int i=0;i<input.length();i++) {
			
			char c= input.charAt(i);
			if(!charMap.containsKey(c)) {
				charMap.put(c, 1);
				result = Math.max(charMap.size(), result);
				
			} else {
				while(k < i) {
					if(input.charAt(k) == c) {
						k++;
						break;
					} else {
						charMap.remove(input.charAt(k));
						k++;
					}
					
				}
				
			}
			
		}		
		return result;
	}
	
	
	
	
	public static int LongestStringNonRepeating(String input)
	{
		
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		int result = 0;
		int k = 0;
		
		for(int i=0;i<input.length();i++)
		{
			Character c = input.charAt(i);
			if(!charMap.containsKey(c))
			{
				//charMap.put(c, charMap.get(c)+1);
				charMap.put(c, 1);
				result = Math.max(result, charMap.size());
			} else
			{
				while(k < i)
				{
					if(c == input.charAt(k))
					{
						k++;
						break;
					} 
					else
					{
						charMap.remove(input.charAt(k));
						k++;
						
					}
					
				}
				
			}
			
			
			
		}
		return result;
		
		
	}

}
