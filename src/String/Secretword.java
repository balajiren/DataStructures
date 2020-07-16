package String;
import java.util.*;


class Master {
	
	public int guess(String guess) {
		return 0;
	}
	
}

public class Secretword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//pseudocode version 2
//	for(int i = 0, matches = 0; i < 10 && matches != 6; i ++){
//		matches = master.guess(a word in candidates);
//
//		for(String candidate: candidates){
//			if(matches == getMatches(candidate, word)){
//				tempCandidates.add(candidate);
//			}
//		}
//
//		candidates = tempCandidates;
//	}
	
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
