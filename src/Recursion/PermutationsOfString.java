package Recursion;

import java.util.HashSet;

public class PermutationsOfString {

	public char[] input;
	public PermutationsOfString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String  arr = "abra";
        //getAllPermutations(arr);
		PrintPermuations(arr.toCharArray(),0,0,arr.length());
	}

	public static HashSet<String> getAllPermutations(String str) {
	        // Create a hash set to prevent any duplicate entries
	        HashSet<String> permutations = new HashSet<String>();
	         
	        if(str == null || str.length() == 0) {
	            permutations.add("");
	            return permutations;
	        }	
	         
	        char first = str.charAt(0);
	        String remainingString = str.substring(1);
	        HashSet<String> words = getAllPermutations(remainingString);
	        for(String word: words) {
	            for(int i = 0; i <= word.length(); i++) {
	                String prefix = word.substring(0, i);
	                String suffix = word.substring(i);
	                permutations.add(prefix + first + suffix);
	                System.out.print(prefix + first + suffix+"\n");
	            }
	        }
	        return permutations;
	}
	  
	public static void PrintPermuations(char[] input,int x, int left, int right)
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
				PrintPermuations(input, x ,left+1, right);
				Swap(input, left, x);
				
				
			}
		}
		
	}
	
		public static void Swap(char[] input, int i, int j)
		{
			Character temp = input[i];
			input[i] = input[j];
			input[j] = temp;

		}
	

}
