package String;
import java.util.*;

public class ShortestWordDistance {
	
	public static void main(String args[])
	{
		List<String> lst = new ArrayList<String>();
		lst.add("practice");
		lst.add("makes");
		lst.add("perfect");
		lst.add("coding");
		int res = FindShortestDistance("practice", "makes", lst);
		System.out.println(res);
		// ["practice", "makes", "perfect", "coding", "makes"].
		
	}
	
	public static int FindShortestDistance(String startWord,String endWord, List<String> words)
	{
		int distance = Integer.MAX_VALUE;
		int end  = words.size()-1;
		int start  = 0;
		int m=-1;
	    int n=-1;
 
		
	    while(start <= end)
	    {
	    	if(words.get(start) == startWord)
	    	{

	    		m = start;
	    		if(n!=-1)
	    		{
	    			distance = Math.min(distance, m-n);
	    		}
	    	} else

	    	if(words.get(start) == endWord)
	    	{
	    		n = start;
	    		if(m!=-1)
	    		{
	    			distance = Math.min(distance, n-m);
	    		}
	    		
	    	}
	    	start++;
	 
	    }
	    return distance;
	}

}
