package String;

import java.util.*;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//MATCHING PATTERN {A,B,A} => {C,D,C}
	public boolean wordPatternOfWordsWithSpace(String pattern, String str) {
	    String[] arr = str.split(" ");  
	    //prevent out of boundary problem
	    if(arr.length != pattern.length())
	        return false;
	 
	    HashMap<Character, String> map = new HashMap<Character, String>();
	    for(int i=0;i<pattern.length();i++)
	    {
	    	Character patternChar = pattern.charAt(i);
	    	if(map.containsKey(patternChar))
	    	{
	    		String mappedWord = map.get(patternChar);
	    		if(mappedWord!=arr[i])
	    		{
	    			return false;
	    		}
	    	} else
	    	if(map.containsValue(arr[i]))
	    	{
	    		return false;
	    		
	    	}
	    	map.put(patternChar, arr[i]);
	    }
	 
	    return true;
	}	
	
	//COMPLETE PATTERN {A,B,A} => {REDGREENRED}
	public static  boolean wordPatternMatchDifferentSize(String pattern, String str) {
	    if(pattern.length()==0 && str.length()==0)
	        return true;
	    if(pattern.length()==0)
	        return false;
	 
	    HashMap<Character, String> map = new HashMap<Character, String>();
	    HashSet<String> set = new HashSet<String>();
	    return helper(pattern, str, 0, 0, map, set);
	}
	
	//pattern = "abab", str = "redblueredblue" should return true.	
	public static boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set){
	    if(i==pattern.length() && j==str.length()){
	        return true;
	    }
	 
	    if(i>=pattern.length() || j>=str.length())
	        return false;
	 
	    char c = pattern.charAt(i);
	    for(int k=j+1; k<=str.length(); k++){
	        String sub = str.substring(j, k);
	        if(!map.containsKey(c) && !set.contains(sub)){
	            map.put(c, sub);
	            set.add(sub);
	            if(helper(pattern, str, i+1, k, map, set))
	                return true;
	            map.remove(c);
	            set.remove(sub);
	        }else if(map.containsKey(c) && map.get(c).equals(sub)){
	            if(helper(pattern, str, i+1, k, map, set))
	                return true;
	        }
	    }
	 
	    return false;
	}


}
