package String;

import java.util.HashMap;

public class MinWindowSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String result = minWindowSubString("ADOBECODEBANC","ABC");
		    System.out.println(result);
	}
	
	
	public static String minWindowSubString(String s, String t) {
	    if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //character counter for t
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	 
	    // character counter for s
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	 
	    int count = 0; // the total of mapped characters
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(map.containsKey(c)){
	                if(map.get(c)<target.get(c)){
	                    count++;
	                }
	                map.put(c,map.get(c)+1);
	            }else{
	                map.put(c,1);
	                count++;
	            }
	        }
	
	        if(count == t.length()){
	            char sc = s.charAt(left);
	            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
	                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
	                    map.put(sc, map.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	 
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	    }
	 
	    return result;
	}
	
	
	public int LongestSubStringWithTwoDistinct(String s)
	{
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int max = 0;
		char[] chars = s.toCharArray();
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			Integer cPresent = map.get(c);
		    if(cPresent < 1)
		    {
		    	map.put(c, 1);
		    } 
		    else
		    {
		    	map.put(c, cPresent+1);
		    }
		    
		    if(map.size() > 2)
			{
			  max = Math.max(max, i-start);
			  while(map.size() > 2)
			  {
				  char t = s.charAt(i);
				  if(map.get(t) > 1){
					  map.put(t,map.get(t)-1);
				  } 
				  else
				  {
					  map.remove(t);
				  }
				  start++;
			  }

				
			}
			

		}
		
		return Math.max(max, s.length()-start);
		
		
	}
	
	  
	
	

}
