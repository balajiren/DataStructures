package String;

public class RegexMatchDFS {
	
	
	public static void main(String args[]) {
		
		
		String s = "helo world";
		String p = "hex?lo";
		
		
//		amc
//		amb?c
//		String word = "hello wo";
//		String word1 = "hello wo".replaceAll("\\s+","");
//		
//		System.out.println(isMatch_recursive(word, "he*lo"));
		System.out.println(isMatch_recur(s, p));
		
		
	}
	
public static boolean isMatch_recur(String s, String p) {
		
		if(p.isEmpty()) {
			return s.isEmpty();
		}
		boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
      
		//return true if first value matches
		if(s.length() > 1 && s.charAt(1) == ' ') {
			if(firstMatch) {
				return true;
			}
			//System.out.println("d"+s.charAt(1)+"d");
		}

		if(p.length() >= 2 && p.charAt(1) == '?') {
            
             return (isMatch_recur(s, p.substring(2)) ||
                    (firstMatch && isMatch_recur(s.substring(1), p)));
			
		} else {
			return  firstMatch && isMatch_recur(s.substring(1),p.substring(1));
		}
		
		
	}  



   static boolean IsMatch_DP(String text, String pattern) {
	   
	   boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
	   
	   dp[text.length()][pattern.length()] = true;
	   
	   for(int i=text.length();i>=0;i--) {
		   
		   for(int j=pattern.length()-1;j>=0;j--) {
			   
			   boolean first_Match = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));
			   
			   if(j+1 < pattern.length() || pattern.charAt(j) == '?') {
				   
				   dp[i][j] = dp[i][j+2] || first_Match && dp[i+1][j];
				   
				   
			   } else {
				   dp[i][j] = first_Match && dp[i+1][j+1];
			   }
			   
			   
		   }
		   
		   
	   }
	   
	   return dp[0][0];
	   
   }
	
	static boolean match(String first, String second)  
	{ 
	  
	    // If we reach at the end of both strings,  
	    // we are done 
	    if (first.length() == 0 && second.length() == 0) 
	        return true; 
	    

	    if(second.contains(" ") && second.charAt(0) == ' ') {
		    System.out.print(second);
	    	return match(first,  
                    second.substring(1)); 
	    }
	    
	    // Make sure that the characters after '*'  
	    // are present in second string.  
	    // This function assumes that the first 
	    // string will not contain two consecutive '*' 
	    if (first.length() > 1 && first.charAt(0) == '*' &&  
	                              second.length() == 0) 
	        return false; 
	  
	    // If the first string contains '?',  
	    // or current characters of both strings match 
	    if ((first.length() > 1 && first.charAt(0) == '?') ||  
	        (first.length() != 0 && second.length() != 0 &&  
	         first.charAt(0) == second.charAt(0))) 
	        return match(first.substring(1),  
	                     second.substring(1)); 
	  
	    // If there is *, then there are two possibilities 
	    // a) We consider current character of second string 
	    // b) We ignore current character of second string. 
	    if (first.length() > 0 && first.charAt(0) == '*') 
	        return match(first.substring(1), second) ||  
	               match(first, second.substring(1)); 
	    return false; 
	}
	
private static boolean dfs(String s, String p, int i, int j) {
        
        //if we arrive at the end of p, but we have not arrived at the end of s,
        //they will not match since it is impossible to  match the rest part of s
        //On the other hand, if we arrive at the end of s, but we have not arrive
        //the end of p, it still may match, if next is [a-z]*, if not they are
        //still not match. So when we arrive at the end of s, we must judge it
        //to be false, when next char of p is not *. Namely, when we arrive at the
        //end of s, we will still keep the program on going
        if (j == p.length())
            return i == s.length();

            
        //when j + 1 is not '*'
        //j cannot be * since we will skip '*'
        //when j is at last, the next cannot be '*'
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if ( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                return dfs(s,p, i + 1, j + 1);
            else // if we arrive at the end of s and we find they are not match, namely the next of p is not * and i doesn't match j
                return false;
        }
        
        //when  j + 1 is '*'
        while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            //if one match, then it match. Using or is not convenient, use if
            if (dfs(s, p, i, j + 2))
                return true;
            i++;//i match, i + 1 match, i + 2 match....
        }
        
        //we should also dfs the one which doest't match the jth character in p or i
        //reaches s end, for example, "aab", "c*a*b" and "aa", "a*b*"
        //if we still not arrive at the end of p, but we have arrived at the end  of s,
        //we keep going and find if the the next one can still matching, until we arrive
        //at the end of p, or we find that they are not match
        return dfs(s, p, i, j + 2);
    }
	
	
	
	
//	1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//	2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//	3, If p.charAt(j) == '*': 
//	   here are two sub conditions:
//	               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//	               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//	                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
//	                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//	                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	
	public static boolean isMatch_Final(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '?' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '?') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	}


	
      //O(T+P) 2POWT+P/2
		 public static boolean isMatch_recursive(String text, String pattern) {
		        if (pattern.isEmpty()) return text.isEmpty();
		        boolean first_match = (!text.isEmpty() &&
		                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
		        
		       
		        if(text.contains(" ")) {
		        	if(text.charAt(1) == ' ') {
		        		if(first_match) {
		        			return true;
		        		}
		        	}
		        }

		        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
		            return (isMatch_recursive(text, pattern.substring(2)) ||
		                    (first_match && isMatch_recursive(text.substring(1), pattern)));
		        } else {
		            return first_match && isMatch_recursive(text.substring(1), pattern.substring(1));
		        }
		  
		}
		
	
	
	 //T*P memory and space
	  public boolean isMatchDP(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--){
	            for (int j = pattern.length() - 1; j >= 0; j--){
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));
	                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i+1][j+1];
	                }
	            }
	        }
	        return dp[0][0];
	    }
	
}
