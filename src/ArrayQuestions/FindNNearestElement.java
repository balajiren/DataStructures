package ArrayQuestions;
import java.util.*;

public class FindNNearestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
   int arr[] = {12, 16, 22, 30, 35, 39, 42, 
                45, 48, 50, 53, 55, 56
               }; 
   int n = arr.length; 
   int x = 35, k = 4; 
   printKclosest(arr, x, 4, n); 

	}
	
	public static int FindCrossOver(int[] nums, int start, int end, int n) {
		
		if(nums[end] <=n) {
			return end;
		}
		if(nums[start] > n) {
			return start;
		}
	
		while(start < end) {
			
			int mid = (start + end)/2;
			if(nums[mid] > n) {	
				end = mid-1;
			}
			if(nums[mid] < n) {
				
				start = mid+1;
			}
			if(nums[mid] <=n && nums[mid+1] > n) {
				return mid;
			}
			
		}
		return n;
		
		
	}
	
	//The time complexity of this method is O(Logn + k).
	static void printKclosest(int arr[], int x, int k, int n) 
	{ 
	    // Find the crossover point 
	    int l = FindCrossOver(arr, 0, n-1, x); 
	    int r = l+1;   // Right index to search 
	    int count = 0; // To keep track of count of elements already printed 
	  
	    // If x is present in arr[], then reduce left index 
	    // Assumption: all elements in arr[] are distinct 
	    if (arr[l] == x) l--; 
	  
	    // Compare elements on left and right of crossover 
	    // point to find the k closest elements 
	    while (l >= 0 && r < n && count < k) 
	    { 
	        if (x - arr[l] < arr[r] - x) 
	            System.out.printf("%d ", arr[l--]); 
	        else
	        	System.out.printf("%d ", arr[r++]); 
	        count++; 
	    } 
	  
	    // If there are no more elements on right side, then 
	    // print left elements 
	    while (count < k && l >= 0) 
	    	System.out.printf("%d ", arr[l--]);
	        count++; 
	  
	    // If there are no more elements on left side, then 
	    // print right elements 
	    while (count < k && r < n) 
	    	System.out.printf("%d ", arr[r++]);
	        count++; 
	}

}
