package String;

import java.util.Arrays;
import java.util.Comparator;

public class StringComparator implements Comparator<String>{

	
	public String SortChars(String s)
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	@Override
	public int compare(String s1, String s2)
	{
		return SortChars(s1).compareTo(SortChars(s2));
		
	}
	



public static void main(String args[])
{
	 String[] strArray = {"abcd","abc","abce", "acd","abdc"};
	 Arrays.sort(strArray, new StringComparator());
     
     for (int i = 0; i < strArray.length; i++)
     {
         System.out.println(strArray[i]);
     }
	
}

}
