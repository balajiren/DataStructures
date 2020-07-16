	package String;

import java.util.HashMap;
import java.util.HashSet;

public class LongestStringWithKUniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int max = LongestString("abcabcbb");
		//System.out.print(max);
		LongestSubStringWithKDistinct("abcadcacacaca",3);

	}
	
	//abcbbbbcccbdddadacb // 1 1 1 3
	public static int LongestStringWithNonRepeating(String input)
	{
		
		if(input==null || input.length() == 0)
		{
			return 0;
		}
		
		int i=0;
		int start = 0;
		HashSet<Character> se = new HashSet<Character>();
		int length = 0;
		
		while(i< input.length())
		{
			char c = input.charAt(i);
			//if char not present
			if(!se.contains(c))
			{
				se.add(input.charAt(i));
			}
			else
			{  
				length = Math.max(length, se.size());
				while(start<i && input.charAt(start)!=c)
				{
					se.remove(input.charAt(start));
					start++;
					
				}
				start++;
			}
			
			i++;
			
			
		}
		
		length = Math.max(length, se.size());
		return length;
		
		
	}
	
	public int FindSubStringKDistinct(String input, int k)
	{
        int maxCount = 0;
        int left = 0;
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		for(int i=0;i<input.length();i++)
		{
			Character c = input.charAt(i);
			if(hmap.containsKey(c))
			{
				hmap.put(c, 1);
			} else
			{
				hmap.put(c,hmap.get(c)+1);
			}
			
			if(hmap.size() == k)
			{
				maxCount = Math.max(maxCount, i-left);
				while(left < i)
				{
					if(hmap.get(c) > 1)
					{
						hmap.put(c,hmap.get(c)-1);
					} else
					{
						hmap.remove(c);
					}
					
				}
				left++;
				
			}
			maxCount = Math.max(maxCount, input.length()-left);
		}
		return maxCount;
		
	}
	
	
	//abcabcbb
	//abc
	public static void LongestSubStringWithKDistinct(String word, int k)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int maxLen =k;
		char[] chars = word.toCharArray();
		
		for(int c=0;c<chars.length;c++)
		{
 			if(map.containsKey(chars[c]))
			{
				map.put(chars[c], map.get(chars[c])+1);
			}
			else
			{
				map.put(chars[c], 1);
			}

			if(map.size() > k)
			{
				maxLen = Math.max(maxLen, c-left);
				
				while(map.size() > k)
				{
					char fc = word.charAt(left);
					if(map.get(fc) == 1)
					{
						map.remove(fc);
					}
					else
					{
						map.put(fc, map.get(fc)-1);
					}
					
					left++;
				}
				
			}
			
	
		}
		
		maxLen = Math.max(maxLen, word.length()-left);
		//System.out.print(left);
		//System.out.print(maxLen);
		System.out.print(word.substring(left,word.length()));
		
	}
	
	
	
	
	public int longestSubstringWithKRepeating(String s, int k) {
	    HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
	 
	    for(int i=0; i<s.length(); i++){
	 
	        char c = s.charAt(i);
	        if(counter.containsKey(c)){
	            counter.put(c, counter.get(c)+1);
	        }else{
	            counter.put(c, 1);
	        }
	 
	    }
	 
	    HashSet<Character> splitSet = new HashSet<Character>();
	    for(char c: counter.keySet()){
	        if(counter.get(c)<k){
	            splitSet.add(c);
	        }
	    }
	 
	    if(splitSet.isEmpty()){
	        return s.length();
	    }
	 
	    int max = 0;
	    int i=0, j=0;
	    while(j<s.length()){
	        char c = s.charAt(j);
	        if(splitSet.contains(c)){
	            if(j!=i){
	                max = Math.max(max, longestSubstringWithKRepeating(s.substring(i, j), k));
	            }
	            i=j+1;
	        }
	        j++;
	    }
	 
	    if(i!=j)
	         max = Math.max(max, longestSubstringWithKRepeating(s.substring(i, j), k));
	 
	    return max;
	}
	
	
	
	
	public static int LongestString(String input)
	{
		int max = 0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int start=0;
		for(int i=0;i<input.length();i++)
		{
			if(map.containsKey(input.charAt(i)))
			{
				map.put(input.charAt(i), map.get(input.charAt(i))+1);
				
			}
			else
			{
				map.put(input.charAt(i),1);
				
			}
	
			if (map.size() > 2)
			{ 	
				 max = Math.max(max, i-start);
				 while(map.size() > 2)
				 {
					 int count = map.get(input.charAt(start));
					 if(count > 1)
					 {
						 map.put(input.charAt(start), count-1);
					 }
					 else
					 {
						 map.remove(input.charAt(start));
					 }
					 start++;
				 }
				
				
			}
			
		}
		
		max = Math.max(max, input.length() - start);
		System.out.print(input.substring(start,max));
		return max;
		
	}

}
