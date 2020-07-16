package Hashing;
import java.util.*;

public class CharacterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print("aaabccd");

	}
	
	public static String Print(String input)
	{

		Map<Character, Integer> chmap = new HashMap<Character, Integer>();
		for(int i=0;i<input.length();i++)
		{
			Character c = input.charAt(i);
	
			if(chmap.containsKey(c))
			{
				chmap.put(c, chmap.get(c)+1);
			} else
			{
				chmap.put(c, 1);
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> val : chmap.entrySet())
		{
			sb.append(val.getKey().toString()+val.getValue());
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	

}
