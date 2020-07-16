package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		String s = "134";
		char c = 0;
		//dfs(c,s,0,result);
		PrintPermuations(s.toCharArray(),0,0,s.length());

	}
	
	public static void Swap(char[] input, int i, int j)
	{
		Character temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
	}
	
  public static void PrintPerm_Mod(char[] input,int x, int left, int right)
  {
	  
	  if(left==right)
	  {
		  for(int i=0;i<input.length;i++)
		  {
			  System.out.print(input[i]);
		  }
	  }
	  else
	  {
		  
		  for(x=left;x<right;x++)
		  {
			  Swap(input, left, x);
			  PrintPerm_Mod(input,x,left+1,right);
			  Swap(input, x, left);
		  }
	  }
	  
	  
  }
	
	public static void PrintPermuations(char[] input, int x, int left, int right)
	{
		//int x;
		//base case
		if(left == right)
		{
			for(int i=0;i<input.length;i++)
			{
			  System.out.print(input[i]);
			}
			System.out.print(" ");
			
		}
		else
		{
			for(x=left;x < right; x++)
			{
				Swap(input, left, x);
				PrintPermuations(input,x, left+1, right);
				Swap(input, left, x);
				
				
			}
		}
		
	}
	
	public static void dfs(char s,String source,int start,ArrayList<String> result)
	{
	
		if(source.length() == result.size())
		{
			result.add(String.valueOf(s));
			return;
		}
		
		for(int i=start;i<source.length();i++)
		{
			result.add(String.valueOf(source.charAt(i)));
			dfs(source.charAt(i),source,i+1,result);
		}
		
	
	}

}
