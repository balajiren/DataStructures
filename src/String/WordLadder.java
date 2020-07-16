package String;

import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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

	//BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord)) return 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int step = 1;

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int q = 0; q < len; q++) {
				String str = queue.poll();
				char[] arr = str.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char originalChar = arr[i];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (ch == originalChar) continue;
						arr[i] = ch;
						String newStr = String.valueOf(arr);
						if (endWord.equals(newStr)) return step + 1;
						if (set.contains(newStr)) {
							queue.offer(newStr);
							set.remove(newStr);
						}
					}
					arr[i] = originalChar;
				}
			}
			step++;
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
	

	

}



