package Tree;
import java.util.*;

import javax.swing.RootPaneContainer;

public class Trie
{
	private TrieNode root;
	//HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
	public Trie()
	{
		root = new TrieNode();
		
	}
	
	
	public static void main(String args[])
	{
		
		Trie tr = new Trie();
		tr.Insert("balaji");
		boolean result = tr.search("bamaji");
		System.out.println(result);
	}
	
	public  TrieNode searchString(String word)
	{
		Map<Character,TrieNode> children = root.children;
		TrieNode t = null;
		
		for(int i=0;i<word.length();i++)
		{
			Character c = word.charAt(i);
			if(children.containsKey(c))
			{
				t = children.get(c);
				children = t.children;
				
			} else
			{
				return null;
			}
		}
		
		return t;
		
	}


	
	public void Insert(String word)
	{
		HashMap<Character, TrieNode> children = root.children;
		for(int charCount=0;charCount<word.length();charCount++)
		{
			TrieNode t;
			Character c =word.charAt(charCount);
			if(!children.containsKey(c)){
				
				t= new TrieNode(c);
				children.put(c, t);
			}
			else
			{
				t = children.get(c);
			}
			
			children = t.children;
			
			if(charCount == word.length()-1)
			{
				t.isEnd = true;
			}
		}
	
		
	}
	
	

	
	 // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isEnd) 
            return true;
        else
            return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
 
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }
	
	
}