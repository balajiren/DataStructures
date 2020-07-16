package ArrayQuestions;

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



