package String;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class AlientDictionarySortOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public boolean isAlienSorted(String[] words, String order) {       
         for(int i = 0; i < words.length; i++){
             if(i + 1 < words.length){
                 if(words[i].equals(words[i + 1])) continue;
                 if(!inOrder(words[i],words[i + 1], order)) return false;
             }
         }
         return true;      
     }
     private boolean inOrder(String s1, String s2, String order){
         int len = Math.min(s1.length(),s2.length());
         for(int i = 0; i < len; i++){
             if(s1.charAt(i) == s2.charAt(i)) continue;
             if(order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i))) return false;
             else return true;
         }
         return s1.length() <= s2.length();
     }

}
