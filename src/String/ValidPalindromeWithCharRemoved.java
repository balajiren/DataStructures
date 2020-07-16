package String;

public class ValidPalindromeWithCharRemoved {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public boolean validPalindrome(String s) {
        
        return IsPalindrome_Recur(s,0,s.length()-1);
        
    }
    
    
    public static boolean IsPalin(String str,  
                       int low, int high) 
    { 
        while (low < high)  
        { 
            if (str.charAt(low) != str.charAt(high)) 
                return false; 
            low++; 
            high--; 
        } 
        return true; 
    } 
    
    public static boolean IsPalindrome_Recur(String s, int low, int high) {
        
        while(low < high) {
            
            if(s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                
                if (IsPalin(s, low + 1, high)) {
                    return true;
                }
                
                 
                if (IsPalin(s, low, high-1)) {
                    return true;
                }
               return false;
            }
        
        }
        return true;
        
    }

}
