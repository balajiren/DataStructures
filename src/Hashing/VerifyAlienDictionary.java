package Hashing;

//https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/
public class VerifyAlienDictionary {


    public boolean isAlienSorted(String[] words, String order) {

        //map(h) => 1
        int[] index = new int[26];
        for(int i=0;i<order.length();i++) {
            index[order.charAt(i)-'a'] = i;
        }

        for(int i=1;i<words.length;i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if(!Search(word1,word2,index)) {
                return false;
            }
        }


        return true;
    }



    public boolean Search(String word1, String word2, int[] index) {

        for(int k=0;k<Math.min(word1.length(),word2.length());k++) {
            if (word1.charAt(k) != word2.charAt(k)) {
                if(index[word1.charAt(k)-'a'] > index[word2.charAt(k)-'a']) {
                    return false;
                }
                if(index[word1.charAt(k)-'a'] < index[word2.charAt(k)-'a']) {
                    return true;
                }

            }


        }

        return (word2.length() > word1.length());


    }
}
