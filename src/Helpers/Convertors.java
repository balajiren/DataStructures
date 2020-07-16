package Helpers;

public class Convertors {
	
	public static String ConvertToString(Integer input)
	{
		return String.valueOf(input);
	}
	
	public static int StringToInteger(String input)
	{
		if(input.length() > 0)
		{
			return Integer.parseInt(input);
		}
		return -1;
	}

}
