package ArrayQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MaxOfEachSubArray {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] ar = new int[]{9, 2, 3, 4, 8, 5, 6, 10};
		
		 //MinSlideArray(3);
		 //maxsInEveryWindows(ar,3);
		
		 System.out.print(Arrays.toString(maxsInEveryWindows(ar,3)));

	}
	
	
	public static Integer[] maxsInEveryWindows(int[] arr, int k) {
	    Deque<Integer> deque = new ArrayDeque<Integer>();
	    /* Process first k (or first window) elements of array */
	    for (int i = 0; i < k; i++) {
	        // For very element, the previous smaller elements are useless so
	        // remove them from deque
	        while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
	            deque.removeLast(); // Remove from rear
	        }
	        // Add new element at rear of queue
	        deque.addLast(i);
	    }
	    List<Integer> result = new ArrayList<Integer>();
	    // Process rest of the elements, i.e., from arr[k] to arr[n-1]
	    for (int i = k; i < arr.length; i++) {
	        // The element at the front of the queue is the largest element of
	        // previous window, so add to result.
	        result.add(arr[deque.getFirst()]);
	        // Remove all elements smaller than the currently
	        // being added element (remove useless elements)
	        while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
	            deque.removeLast();
	        }
	        // Remove the elements which are out of this window
	        while (!deque.isEmpty() && deque.getFirst() <= i - k) {
	            deque.removeFirst();
	        }
	        // Add current element at the rear of deque
	        deque.addLast(i);
	    }
	    // Print the maximum element of last window
	    result.add(arr[deque.getFirst()]);

	    return result.toArray(new Integer[0]);
	}
	
	public static void MinSlideArray( int k){

		Deque<Integer> d = new ArrayDeque<Integer>(k) ;
		
		int[] ar = new int[]{9, 2, 3, 4, 8, 5, 6, 10};
		int i =0 ;
		for(; i<k; i++){
         
		    //any large element than the current element need to be removed
			while((!d.isEmpty() && ar[i] >= ar[d.getLast()])){
				d.pollLast();
			}

			d.addLast(i);
		}

		System.out.println("Min in deque");
		for(;i<ar.length; i++){

			System.out.println(ar[d.getFirst()]);

			//Removing front element out of windows
			while((!d.isEmpty() && d.getFirst() <= (i-k))){
				d.pollFirst();
			}

			while((!d.isEmpty() && ar[i] >= ar[d.getLast()])){
				d.pollLast();
			}

			d.addLast(i);
		}

		System.out.println(ar[d.getFirst()]);
	}
	
	
	
	
	
	public static void MinSubArrayElement(int[] input, int k)
	{
		int i=0;
		Deque<Integer> d = new ArrayDeque<Integer>();
		for(;i<k;i++)
		{
			 while(!d.isEmpty() && input[i] <= input[d.getLast()])
			 {
				 d.removeLast();
			 }
			 d.addLast(i);
			
		}
		for(;i<input.length;i++)
		{
			System.out.println(input[d.getFirst()]);
			while(!d.isEmpty() &&  d.getFirst() <= i-k)
			{
				d.pollFirst();
			}
			
			while(!d.isEmpty() && input[i] <= input[d.getLast()])
			{
				d.pollLast();
			}
			
			d.addLast(i);
		}
		
		
		
	}
	
}
