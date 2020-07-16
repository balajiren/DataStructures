package String;
import java.util.*;
//https://leetcode.com/problems/string-transforms-into-another-string/
public class StringTransform {

    public boolean canConvert(String str1, String str2) {
        int[] chars = new int[26];
        if(str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> root = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            chars[c2-'a']++;

            if(c1 == c2) {
                continue;
            }
            if(!root.containsKey(c1)) {
                root.put(c1,c2);
            } else {
                if(root.get(c1)!=c2) {
                    return false;
                }
            }


        }

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) count++;
        }
        return count > 0;
        //return true;

    }
}
