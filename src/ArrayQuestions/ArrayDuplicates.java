package ArrayQuestions;

import java.util.*;

public class ArrayDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] input = new int[] {2,1,4,1,2,4,5,6,7,5};
		 FindDuplicates(input);

	}
	
	
	public static Set<Integer> FindDuplicates(int[] input)
	{
	   
	   Set<Integer> result = new HashSet<Integer>();
	   
	   int n = input.length;
	   int[] temp = new int[n];
	   for(int i=0; i<n;i++)
		{
			   temp[i] = 0;
		}
	   for(int i=0; i<n;i++)
	{
	    if(temp[input[i]] == 0)
	    {
	    	temp[input[i]] = -1;

	    }
	    else if(temp[input[i]] == -1)
		{ 
		  result.add(input[i]);
		}


	}
	for(int i : result)
	{
		System.out.println(i + " ");
	}
	   return result;

	}

}
