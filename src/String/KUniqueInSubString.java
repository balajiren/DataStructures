package String;

import java.util.*;
public class KUniqueInSubString {

	
	public int LongestSubStringKDistinct(String str, int k)
	{
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int maxlen = 0;
		int left = 0;
		for(int i=0;i<str.length();i++)
		{
			Character c = str.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			} else
			{
				map.put(c,1);
			}
			{
  
			maxlen = Math.max(maxlen, i-left);
			if(map.size() > k)
			{
				while(map.size() > k)
				{
                   char ch = str.charAt(left);
                   if(map.get(c) > 1)
                   {
                	   map.put(c, map.get(c)-1);
                   } else
                   {
                	   map.remove(ch);
                   }
				   left++;
				}
			}
	    }
	  }
	  return Math.max(maxlen, str.length()-maxlen);

	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
	    if(k==0 || s==null || s.length()==0)
	        return 0;
	 
	    if(s.length()<k)
	        return s.length();
	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    int maxLen=k;
	    int left=0;
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	        
	        if(map.size()>k){
	            maxLen=Math.max(maxLen, i-left);
	 
	            while(map.size()>k){
	 
	                char fc = s.charAt(left);
	                if(map.get(fc)==1){
	                    map.remove(fc);
	                }else{
	                    map.put(fc, map.get(fc)-1);
	                }
	 
	                left++;
	            }
	        }
	 
	    }
	 
	    maxLen = Math.max(maxLen, s.length()-left);
	 
	    return maxLen;
	}
	//Time is O(n).
}
