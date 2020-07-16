package Problems;

import java.util.Arrays;

//https://www.careercup.com/question?id=4892464248782848
//You are given two arrays - A & B. The length of the arrays is the same - N. 
//The values in the arrays are integers from 0 to N - 1 in random order and no number is repeated. You need to list a sequence of two-element swaps required to reorder the array A into the order of the array B. Additionally, at each step of the sequence you are allowed to swap two elements only if one of them is 0.
public class ReOrderArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void equalize(int[] a1, int[] a2)
	{
		int k = -1;
		for(int i=0;i<a2.length;i++)
		{
			if(a2[i]==0)
			{
				k = i;
			}
			
		}
		
		 for (int i = 0; i < a1.length; i++) {
		        if (a2[i] != a1[i]) {
		            int j = Arrays.binarySearch(a2, a1[i]);
		            Swap(a2, i, k);
		            Swap(a2, k, j);
		            Swap(a2, j, i);
		        }
		    }
		
		
	}
	
	public void Swap(int[] source, int v1, int v2)
	{
		int temp = source[v1];
		source[v1] = source[v2];
		source[v2] = temp;
		
		
	}




}
