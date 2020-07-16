package String;

import java.util.Arrays;

public class RemoveSpaces {

	public RemoveSpaces() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ReplaceSpaces("i love you balaji and swathi"));

	}
	
	public String ReplaceSpace(String input, String placeholder)  {
		
		char[] chars = input.toCharArray();
		int size = input.length();
		String output= "";
		StringBuilder builder = new StringBuilder(size);
		
		for(char c : chars) 
		{
			builder.append(String.valueOf(c));
			if(chars[c] == ' ') {
						builder.append(String.valueOf("%20"));

			}
		}
		
		return builder.toString();
		
	}
	
	public static String ReplaceSpaces(String input)
	{

		if(input.length() == 0)
		{
			return null;
		}
		char[] arr = input.toCharArray();
		int numspaces = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == ' ')
			{
				numspaces+=1;
			}
			else
			{
				arr[i-numspaces] = arr[i];
			}
		}
				
		arr = Arrays.copyOf(arr, arr.length - numspaces);
		return new String(arr);
		
		
	}

}
