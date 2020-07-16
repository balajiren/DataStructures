package ArrayQuestions;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

	static HashSet<String> dictWords = new HashSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dictWords = new HashSet<String>();
		dictWords.add("pit");
		dictWords.add("pot");
		dictWords.add("mot");
		dictWords.add("not");
		dictWords.add("hot");

	}
	
   
	
	public void FindLadders(String start, String end, Set<String> dict)
	{
		
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1,null));
		dict.add(end);
		HashSet<String> visited = new  HashSet<String>();
		HashSet<String> unvisited = new  HashSet<String>();
		unvisited.addAll(dict);
		
		while(queue.isEmpty())
		{
			WordNode node = queue.remove();
			String word = node.word;
			
			
			
			
			
			char[] arr = word.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
				char temp = arr[i];
				for(char c ='a';c<='z';c++)
				{
					if(arr[i] !=c)
					{
						arr[i] = c;	
					}
					
					String newword = new String(arr);
					if(unvisited.contains(newword))
					{
						queue.add(new WordNode(newword, node.numOfSteps+1, node));
						visited.add(newword);
					}
					
				}
				arr[i] = temp;
				
			}
				
			
			
			
			
		}
		
		
		
	}

}
