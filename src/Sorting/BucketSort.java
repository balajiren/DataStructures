package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input1 = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 90 };
		
		BucketSort(input1);
		System.out.println(Arrays.toString(input1));
		

		

	}
	
	
	/** * * @param input * @return an array containing hash of input */
	private static int[] hash(int[] input) 
	{ 
		int m = input[0];
		for (int i = 1; i < input.length; i++)
		{ 
			if (m < input[i]) { m = input[i]; 
			} 
		} 
		return new int[] { m, (int) Math.sqrt(input.length) };
	} 
	/** * * @param i * @param code * @return */
	private static int hash(int i, int[] code) 
	{
		return (int) ((double) i / code[0] * (code[1] - 1)); 
	}

	
	public static void BucketSort(int[] input)
	{

		final int[] code = hash(input);

	    ArrayList<Integer> buckets[] = new ArrayList[code[1]];

	    for (int i = 0; i < code[1]; i++) { //initialize buckets
	    buckets[i] = new ArrayList();

	    }

	    for (int i : input) { //partition the input array
	    	buckets[hash(i, code)].add(i);
	   	}
	    for (int i = 0; i < buckets.length; i++) {
	    	
		    Collections.sort(buckets[i]); //mergeSort
	    	
	    }
		
	    int pointer = 0;

	    for (int j = 0; j < buckets.length; j++) { //merge the buckets
	    	for(int v : buckets[j])
	    	{
	    	input[pointer++] = v;
	    	}

	    }

	}

}
