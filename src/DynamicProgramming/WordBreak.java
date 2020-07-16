package DynamicProgramming;

import java.util.Arrays;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public boolean wordBreak(String s, Set<String> dict) {
	        boolean[] t = new boolean[s.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<s.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String a: dict){
	                int len = a.length();
	                int end = i + len;
	                if(end > s.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(s.substring(i, end).equals(a)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[s.length()];
	    }
	
	public boolean WordBreak(String s, Set<String> wordDict)
	{
	    int[] pos = new int[s.length()+1];
	    Arrays.fill(pos, -1);
	    
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				if(wordDict.contains(s.substring(i, j)))
				 {
					pos[j] = i;
				 }
			}
		
			
		}
		return pos[s.length()]!=-1;
		
	}

}
