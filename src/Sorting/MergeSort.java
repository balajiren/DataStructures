package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

	 private static int[] numbers;
     private static int[] helper;
    private static int number;

	public static void main(String[] args) {
		 numbers = new int []{14, 32, 67, 76, 23, 41, 58, 85};
		 helper = new int[numbers.length];
		 mergesort(0, numbers.length-1);
			System.out.println(Arrays.toString(numbers));


	}
	
	public static void mergesort(int low , int high)
	{
		 if (low < high) {
	            // Get the index of the element which is in the middle
	            int middle = low + (high - low) / 2;
	            // Sort the left side of the array
	            mergesort(low, middle);
	            // Sort the right side of the array
	            mergesort(middle + 1, high);
	            // Combine them both
	            Merge(low, middle, high);

	        }

	}

public static void Merge(int low, int mid, int high)
{
	
 for (int i = low; i <= high; i++) {
         helper[i] = numbers[i];
     }
	int i = low;
	int j = mid+1;
	int k = low;
	while(i <= mid && j <= high)
	{
		if(helper[i] <= helper[j])
		{
			numbers[k] = helper[i];
			i++;
		}
		else  
		{
			numbers[k] = helper[j];
			j++;
		}
		k++;
	}
	while(i<=mid)
	{
		numbers[k] = helper[i];
		k++;
		i++;
		
	}
	
}
	
	
	


}
