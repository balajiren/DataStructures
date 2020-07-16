package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

	public static void PrintMessage(String s)
	{
		
		System.out.println(s);
		
	}
	
	public static void PrintMessage(Integer s)
	{
		
		System.out.println(s);
		
	}
	
	public static void PrintMessage(int[] arr)
	{
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void PrintMessage(String[] arr)
	{
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	public static String JoinWords(String[] words)
	{
		
		StringBuffer buffer = new StringBuffer();
		for(String w: words)
		{
			buffer.append(w);
		}
		return buffer.toString();
	}
	
	public static List ReadFileToAray(String filePath)
	{
		List<String> lstValues = new ArrayList<String>();
		try
		{
	
			FileReader reader = new FileReader(filePath);
			BufferedReader buf  = new BufferedReader(reader);
			String line = "";
			while( (line = buf.readLine())!=null)
			{
				lstValues.add(line);
			}
		}
		catch(Exception ex)
		{
			
		}
	
		return lstValues;
		
		
		
	}
			
}
