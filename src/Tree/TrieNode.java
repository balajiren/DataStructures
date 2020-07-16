package Tree;
import java.util.*;
public class TrieNode {

	TrieNode[] arr;
	boolean isEnd;
	char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	public TrieNode()
	{
		
	}
	public TrieNode(Character c)
	{
		this.arr = new TrieNode[26];
		this.c = c;
	}
}

