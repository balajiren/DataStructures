package Sorting;
import java.util.*;

public class NewMergeSort {

    private static int[] numbers;
    private static int[] helper;

    private int number;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 numbers = new int []{14, 32, 67, 76, 23, 41, 58, 85};
		 helper = new int[numbers.length];
		 mergesort(0, numbers.length-1);
			System.out.println(Arrays.toString(numbers));

	}
	

	    private static void mergesort(int low, int high) {
	        // check if low is smaller than high, if not then the array is sorted
	        if (low < high) {
	            // Get the index of the element which is in the middle
	            int middle = low + (high - low) / 2;
	            // Sort the left side of the array
	            mergesort(low, middle);
	            // Sort the right side of the array
	            mergesort(middle + 1, high);
	            // Combine them both
	            merge(low, middle, high);
	            System.out.println(Arrays.toString(numbers));
	        }
	    }

	    private static void merge(int low, int middle, int high) {

	        // Copy both parts into the helper array
	        for (int i = low; i <= high; i++) {
	            helper[i] = numbers[i];
	        }

	        int i = low;
	        int j = middle + 1;
	        int k = low;
	        // Copy the smallest values from either the left or the right side back
	        // to the original array
	        while (i <= middle && j <= high) {
	            if (helper[i] <= helper[j]) {
	                numbers[k] = helper[i];
	                i++;
	            } else {
	                numbers[k] = helper[j];
	                j++;
	            }
	            k++;
	        }
	        // Copy the rest of the left side of the array into the target array
	        while (i <= middle) {
	            numbers[k] = helper[i];
	            k++;
	            i++;
	        }
	        // Since we are sorting in-place any leftover elements from the right side
	        // are already at the right position.

	    }

}
