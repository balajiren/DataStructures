package String;
import java.util.*;

//Input: ["bella","label","roller"]
//Output: ["e","l","l"]
public class FindCommonChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++){
            int minCount = Integer.MAX_VALUE;
            for (String s : A){
                int wordCount = 0;
                for (char cur_c : s.toCharArray()) {
                    if (cur_c == c) wordCount++;
                }
                minCount = Math.min(minCount, wordCount);
            }
            
            for (int i = 0; i < minCount; i++) result.add("" + c);
        }
        
        return result;
   }
	
	

}
