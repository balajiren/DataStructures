package Searching;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search();
	}
	
	public static void Search() {
		
		int result;
		int[] input = new int[]{1,4,6,10,20,40,55};
		System.out.print(Arrays.binarySearch(input, 1,4,40));
		
		
	}

}
