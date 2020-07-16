package String;
import java.util.*;

//https://leetcode.com/problems/guess-the-word/discuss/556075/How-to-explain-to-interviewer-843.-Guess-the-Word
//Time Complexity: O(10n) = O(n), beucase the for loop runs 10 or less times and in each iteration, we traverse the wordlist,
//Space Complexity: O(10n) = O(n)
//Space Complexity: O(10n) = O(n)
//pseudocode version 3
//for(int i = 0, matches = 0; i < 10 && matches != 6; i ++){
//        matches = master.guess(randomly select a word in candidates);
//        for(String candidate: candidates){
//        if(matches == getMatches(candidate, word)){
//        tempCandidates.add(candidate);
//        }
//        }
//
//        candidates = tempCandidates;
//        }
public class GuessWords {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for(int i = 0, matches = 0; i < 10 && matches != 6; i ++){
            String guess = wordlist[random.nextInt(wordlist.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for(String word: wordlist){
                if(matches == getMatches(guess, word)){
                    candidates.add(word);
                }
            }

            wordlist = candidates.toArray(new String[0]);
        }
    }

    private int getMatches(String word1, String word2){
        int matches = 0;
        for(int i = 0; i < word1.length(); i ++){
            if(word1.charAt(i) == word2.charAt(i)){
                matches ++;
            }
        }

        return matches;
    }
}
