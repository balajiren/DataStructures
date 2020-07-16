package String;

public class WildCardMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("test");
		System.out.println(IsMatch1("hello world","h*llo"));
	}
	
	
	 public static boolean IsMatch1(String text, String pattern) {
	        
	        int slen = text.length();
	        int plen = pattern.length();
	        
	        int sIdx=0;               
	        int currentIndex=0;
	        int patternIndex=0;
	        int starIndex = -1;
	        int tempIndex = -1;
	        
	        while(currentIndex < slen) {
	           if(patternIndex < plen && (pattern.charAt(patternIndex) == '?' || (pattern.charAt(patternIndex) == text.charAt(currentIndex)))) {
	               patternIndex++;
	               currentIndex++;
	           } else
	           if(patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
	               starIndex = patternIndex;
	               patternIndex++;
	               tempIndex = currentIndex;
	               
	           }  else if(starIndex == -1) {
	               return false;
	           } else {
	               patternIndex = starIndex+1;
	               currentIndex = tempIndex + 1;
	               tempIndex = currentIndex;
	           }
	            
	            
	        }
	        int pLen = pattern.length();
	        for(int i = patternIndex; i < pLen; i++) {
	            if (pattern.charAt(i) != '*') return false;
	        }
	        return true;
	        
	        
	    }
	
	public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count==0 && m != n) return false;
        else if (n - count > m) return false;
        
        boolean[] match = new boolean[m+1];
        match[0] = true;
        for (int i = 0; i < m; i++) {
            match[i+1] = false;
        }
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < m; j++) {
                    match[j+1] = match[j] || match[j+1]; 
                }
            } else {
                for (int j = m-1; j >= 0; j--) {
                    match[j+1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];
    }
	
	
	

}
