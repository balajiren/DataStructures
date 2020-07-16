package ArrayQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayInversion {
	
	private static BigDecimal total = new BigDecimal(0);
	public static void main(String[] args)
	{
		int[] arr = {2,3,4,4,4};
		divideAndConquer(arr); 
		System.out.println("Number of inversions: " + total);
		
	}
	
	public  static int[] divideAndConquer(int[] inputArray) {
		  int n = inputArray.length;
		  if(n == 1) {
		    return inputArray;
		  }
		  int mid = n/2;
		  int[] leftArray = new int[mid];
		  int[] rightArray = new int[n - mid];
		  System.arraycopy(inputArray, 0, leftArray, 0, leftArray.length);
		  System.arraycopy(inputArray, leftArray.length, rightArray, 0, rightArray.length);
		  divideAndConquer(leftArray);
		  divideAndConquer(rightArray);
		  merge(leftArray, rightArray, inputArray);
		  return inputArray;
		}
	
	public static void merge(int[] leftArray, int[] rightArray, int[] sortedArray) {
		  int leftArrayLength = leftArray.length;
		  int rightArrayLength = rightArray.length;
		  int i = 0;
		  int j = 0;
		  int k = 0;
		  while(i < leftArrayLength && j < rightArrayLength) {
		    if(leftArray[i] < rightArray[j]) {
		      sortedArray[k] = leftArray[i];
		      i++;
		    } else {
		      sortedArray[k] = rightArray[j];
		      j++;
		      total = total.add(new BigDecimal(leftArray.length - i));
		    }
		    k++;
		  }
		  while(i < leftArrayLength) {
		    sortedArray[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  while(j < rightArrayLength) {
		    sortedArray[k] = rightArray[j];
		    j++;
		    k++;
		  }
		}

}
