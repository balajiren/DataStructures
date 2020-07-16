package String;

import Common.Utils;

import java.util.*;

public class StringPermutations {

	public char[] input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CheckStringIsPermutationOfOther("PSJ","JSP");
		FindPermuatations("abra".toCharArray(),0,"abra".length());
	}
	
	//abc
	public static void FindPermuatations(char[] input,int l , int r)
	{
		 int x;
         if(l == r)
         {
        	 //print a
        	 for(int i=0;i<input.length;i++)
        	 {
        		 System.out.println(input[i]);
        	 }
        	 
        	 System.out.println(" ");
         }
		  
         else
         {
        	 for(x = l ; x < r; x++)
        	 {
        		 Swap(input,l,x);
        		 FindPermuatations(input,l+1,r);
        		 Swap(input,l,x);
        	 }
        	 
        	 
         }
		
	}
	
	public static void Swap(char[] input, int l, int r)
	{
		char temp  = input[l];
		
		input[l] = input[r];
		
		input[r] = temp;
		
		
	}
	
	
	
	public static void Permute(String prefix,String sourceString)
	{
		
		if(sourceString.length() <= 1)
		{
			//Utils.PrintMessage(sourceString); 
		}
		if(sourceString.length() == 0)
		{
			System.out.print(prefix + "\n");
		}
		for(int i=0;i<sourceString.length();i++)
		{
			Permute(prefix+sourceString.charAt(i), sourceString.substring(0,i)+ sourceString.substring(i+1,sourceString.length()));
		}
	}
	
	
	public static boolean CheckStringIsPermutationOfOther(String s1, String s2)
	{
		if(s1.length() != s2.length())
		{
			return false;
		}
		Hashtable<Character, Integer> charHash = new Hashtable<Character,Integer>();
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		
		for(int i=0;i<chars1.length;i++)
		{
			if(charHash.contains(chars1[i]))
			{
				charHash.put(chars1[i], charHash.get(chars1[i])+1);
			}
			else
			{
				charHash.put(chars1[i],1);
			}
		}
		
		for(int j=0;j<chars2.length;j++)
		{
			if(charHash.contains(chars2[j]))
			{
				charHash.put(chars2[j], charHash.get(chars2[j]-1));
			}
		}
		
		for(Character c: charHash.keySet())
		{
			if(charHash.get(c)!=0)
			{
				return false;
			}
		}
		return true;
	}
	

}
