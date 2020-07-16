package BackTracking;
import java.util.*;

//https://leetcode.com/problems/word-break-ii
public class WordBreak2 {
	

    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, List<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if(map.containsKey(start)) {
            return map.get(start);
        }
        if(start == s.length()) {
            res.add("");
        }
        for(int end=start+1;end<=s.length();end++) {
            if(wordDict.contains(s.substring(start,end))) {
                
                List<String> temp = word_Break(s,wordDict,end);
                for(String t : temp) {
                    res.add(s.substring(start, end) + (t.equals("") ? "" : " ") + t );
    
                }
                
                
            }
       
            
        }
        map.put(start,res);
        return res;
    }

}
