package String;

import java.util.*;

public class ReArrangeStringKDigitsApart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//iterate and position k swap
	public String ReArrange(String str, int k)
	{
		StringBuilder input = new StringBuilder();
		if(k==0)
	        return str;
	 
	    //initialize the counter for each character
	    final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<str.length(); i++){
	        char c = str.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	    }
	    //sort hash map by frequency
	    PriorityQueue<Character> que= new PriorityQueue<Character>(new Comparator<Character>()
	    		{
	    	         public int compare(Character c1, Character c2)
	    	         {
	    	        	 return map.get(c2).intValue() - map.get(c1).intValue();
	    	         }
	    	
	    		});
	    
	     for(char c : map.keySet())
	     {
	    	 que.offer(c);
	    	 
	     }
	     int len = str.length();
	     while(que.size() == 0)
	     {
	    	 int min = Math.min(k,len);
	    	 ArrayList<Character> temp = new ArrayList<Character>();
		     for(int i=0;i<min;i++)
		     {
		    	 if(que.size() == 0)
		    	 {
		    		 return input.toString();
		    	 }
		    	 Character c = que.poll();
		    	 input.append(c);
		    	 map.put(c,map.get(c)-1);
		    	 if(map.get(c) > 0)
		    	 {
		    		 temp.add(c);
		    	 }
		    	 len--;
		     }
		     for(Character c : temp)
		     {
		    	 que.offer(c);
		     }
	     }
		return input.toString();
	}
}
