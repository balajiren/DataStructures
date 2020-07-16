package Sorting;

import java.util.Arrays;

public class ThreeWayQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
		sort(nums,0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	
	 public static void sort(int[] input, int lowIndex, int highIndex) {
	      
	      
	      if (highIndex<=lowIndex) return;
	      
	      int lt=lowIndex;
	      int gt=highIndex;
	      int i=lowIndex+1;
	      
	      int pivotIndex=lowIndex;
	      int pivotValue=input[pivotIndex];
	      
	      
	      while (i<=gt){
	          
	          
	          if (less(input[i],pivotValue)){
	              exchange(input, i++, lt++);
	          }
	          else if (less (pivotValue, input[i])){
	              exchange(input, i, gt--);
	          }
	          else{
	              i++;
	          }
	              
	          
	      }
	      
	      sort (input, lowIndex, lt-1);
	      sort (input, gt+1, highIndex);
	      
	      
	  }

	public static boolean less(int a, int b) {
		return a < b;
	}

	public static void exchange(Comparable array[], int from, int to) {

		Comparable temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

	public static void exchange(int[] input, int i, int r) {
		int temp = input[i];
		input[i] = input[r];
		input[r] = temp;
	}



}
