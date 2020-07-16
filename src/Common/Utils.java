package Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import LinkedList.Node;

public class Utils {

	public static void PrintMessage(String s)
	{
		
		System.out.println(s);
		
	}
	
   
	//Collections.addAll(c, elements)
	

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
