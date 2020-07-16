package ArrayQuestions;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlySortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int k = 3; 
	        int arr[] = { 2, 6, 3, 12, 56, 8 }; 
	        int n = arr.length; 
	        kSort(arr, n, k); 
	        System.out.println("Following is sorted array"); 
	        printArray(arr, n); 

	}
	
	
	private static void printArray(int[] arr, int n)  
    { 
        for(int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
	
	private static void kSort1(int[] arr, int n, int k)  
    { 
  
        // min heap 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 
  
        // add first k + 1 items to the min heap 
        for(int i = 0; i < k + 1; i++) 
        { 
            priorityQueue.add(arr[i]); 
        } 
  
        int index = 0; 
        for(int i = k + 1; i < n; i++)  
        { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
            priorityQueue.add(arr[i]); 
        } 
  
        Iterator<Integer> itr = priorityQueue.iterator(); 
  
        while(itr.hasNext())  
        { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
        } 
  
    } 
	
	public static int[] kSort(int[] nums, int n, int k) {
		
	//min heap
    PriorityQueue<Integer> pq = new PriorityQueue<>(); 
    
    for(int i=0;i<k+1;i++) {
    	pq.add(nums[i]);
    	
    }
    int index=0;
    
    for(int i = k + 1; i < n; i++)   {
    	nums[index++] = pq.poll();
    	pq.add(nums[i]);
    	
    }
    Iterator<Integer> itr = pq.iterator();
    while(itr.hasNext())  {
    	nums[index++] = pq.poll(); 
    	
    }
     
    return nums;
		
	}

}
