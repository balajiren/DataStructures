package BFS;

import java.util.*;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import String.WordNode;


class LadderPair<T,K> {

	LadderPair(String one, Integer two) {

	}

	public String getKey() {
		return "";
	}
	public Integer getValue() {
		return 0;
	}

}

public class WordLadder {
	

	static HashSet<String> dictWords;
	
	public static void main(String args[])
	{
		dictWords = new HashSet<String>();
		dictWords.add("pit");
		dictWords.add("pot");
		dictWords.add("mot");
		dictWords.add("not");
		dictWords.add("hot");
		int steps = ladderLength("pit","not",dictWords);
		System.out.print("Number of Steps"+ steps);
	
	
	}


	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		// Since all words are of same length.
		int L = beginWord.length();

		// Dictionary to hold combination of words that can be formed,
		// from any given word. By changing one letter at a time.
		Map<String, List<String>> allComboDict = new HashMap<>();

		wordList.forEach(
				word -> {
					for (int i = 0; i < L; i++) {
						// Key is the generic word
						// Value is a list of words which have the same intermediate generic word.
						String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
						List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
						transformations.add(word);
						allComboDict.put(newWord, transformations);
					}
				});

		// Queue for BFS
		Queue<LadderPair<String, Integer>> Q = new LinkedList<>();
		Q.add(new LadderPair(beginWord, 1));

		// Visited to make sure we don't repeat processing same word.
		Map<String, Boolean> visited = new HashMap<>();
		visited.put(beginWord, true);

		while (!Q.isEmpty()) {
			LadderPair<String, Integer> node = Q.remove();
			String word = node.getKey();
			int level = node.getValue();
			for (int i = 0; i < L; i++) {

				// Intermediate words for current word
				String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

				// Next states are all the words which share the same intermediate state.
				for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
					// If at any point if we find what we are looking for
					// i.e. the end word - we can return with the answer.
					if (adjacentWord.equals(endWord)) {
						return level + 1;
					}
					// Otherwise, add it to the BFS Queue. Also mark it visited
					if (!visited.containsKey(adjacentWord)) {
						visited.put(adjacentWord, true);
						Q.add(new LadderPair(adjacentWord, level + 1));
					}
				}
			}
		}

		return 0;
	}
	
	
	
	//BREADTH FIRST SEARCH
	 public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	        LinkedList<WordNode> queue = new LinkedList<WordNode>();
	        queue.add(new WordNode(beginWord, 1,null));
	        wordDict.add(endWord);
	        while(!queue.isEmpty()){
	            WordNode top = queue.remove();
	            String word = top.word;
	 
	            if(word.equals(endWord)){
	                return top.numOfSteps;
	            }
	 
	            char[] arr = word.toCharArray();
	            for(int i=0; i<arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	                    if(wordDict.contains(newWord)){
	                        queue.add(new WordNode(newWord, top.numOfSteps+1,null));
	                        wordDict.remove(newWord);
	                    }
	 
	                    arr[i]=temp;
	                }
	            }
	        }
	 
	        return 0;
	    }
	
	public static int FindNumOfSteps(String beginWord, String endWord, Set<String> words)
	{
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1,null));
		words.add(endWord);
		while(!queue.isEmpty())
		{
			WordNode top  = queue.remove();
			
			if(top.word.equals(endWord))
			{
				return top.numOfSteps;
			}
			char[] chars = top.word.toCharArray();
			
			for(int i=0;i<chars.length;i++)
			{
				for(char c='a';c<='z';c++)
				{
					char temp = chars[i];
					if(chars[i]!=c)
					{
						chars[i] = c;
					}
					String newWord = new String(chars);
					if(words.contains(newWord))
					{
						queue.add(new WordNode(newWord,top.numOfSteps+1,null));
						words.remove(newWord);
					}
					chars[i] = temp;
				}
			}
		}
		
		
		return 0;
	}
	

}



