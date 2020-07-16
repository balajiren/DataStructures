package String;
import java.util.*;

public class WordBreak_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> se = new HashSet<String>();
		se.add("leet");
		se.add("code");
		boolean result = FindIfWorkBreak("leetcode" , se);
		System.out.println(result);

	}
	
	
	 public List<String> wordBreak_Space(String s, Set<String> wordDict) {
	        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
	        LinkedList<String> initial = new LinkedList<>();
	        initial.add("");
	        dp[0] = initial;
	        for (int i = 1; i <= s.length(); i++) {
	            LinkedList<String> list = new LinkedList<>();
	            for (int j = 0; j < i; j++) {
	                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
	                    for (String l : dp[j]) {
	                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
	                    }
	                }
	            }
	            dp[i] = list;
	        }
	        return dp[s.length()];
	    }
	
	 
	//Time: O(string length * dict size). Bad if dict size is large
	public boolean WordBreak(String s, Set<String> dict) {
		
		 boolean[] t = new boolean[s.length()+1];
		 
		 
		 for(int i=0;i<s.length();i++) {
			 
			 if(!t[i]) 
	                continue;
			 for(String w : dict) {
				 
				 int len = w.length();
				 
				 int end = i + len;
				 
				 if(t[end]) continue;
				 
				 if(dict.contains(s.substring(i,end))) {
					 t[end]  = true;
				 }
				
				 
			 }
			 
			
		 }
		return t[s.length()];
		
	}
    
	//O(NPOW2) IF LARGE DICT
	public boolean wordBreak(String s, List<String> wordDict) {
        
	     Set<String> wordDictSet = new HashSet(wordDict);
	     boolean[] dp = new boolean[s.length() + 1];
	     dp[0] = true;
	     for(int i=1;i<=s.length();i++) {
	     
	         for(int j=0;j<i;j++) {
	             
	             if(dp[j] && wordDictSet.contains(s.substring(j,i))) {
	                 dp[i] = true;
	                 break;
	             }
	         }
	         
	         
	     }
	         
	      return dp[s.length()]; 
	    }
	
  
	
	public static boolean FindIfWorkBreak(String s, Set<String> dict)
	{
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

	
	//gets all words for the dictionart
	public List<String> wordBreak_dfs(String s, Set<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	 
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	 
	public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}

}
