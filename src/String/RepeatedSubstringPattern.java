package String;

//https://leetcode.com/problems/repeated-substring-pattern/
//Input: "abab"
//        Output: True
//        Explanation: It's the substring "ab" twice.
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length()/2; i++){          //repeated substring can be of max : s.length()/2
            sb.append(s.charAt(i));                     //for each character we append, we check if it fits the pattern in the while loop below
            String temp = sb.toString();
            while(temp.length() <= s.length()){
                if(temp.equals(s))
                    return true;
                temp += sb.toString();
            }
        }
        return false;
    }
}
