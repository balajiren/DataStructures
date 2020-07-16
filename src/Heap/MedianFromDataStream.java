package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFromDataStream {

	
	 PriorityQueue<Integer> minheap  = new PriorityQueue<Integer>();
	   PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
	    public MedianFromDataStream() {
	        minheap  = new PriorityQueue<Integer>();
	        maxheap = new PriorityQueue<Integer>(Comparator.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        minheap.offer(num);
	        maxheap.offer(minheap.poll());
	        if(minheap.size() < maxheap.size()) {
	            minheap.offer(maxheap.poll());
	        }
	        
	        
	    }
	    
	    public double findMedian() {
	        if(minheap.size() > maxheap.size()) {
	            return minheap.peek();
	        }
	        double median = (minheap.peek() + maxheap.peek())/2.0;
	        return median;
	        
	        
	        
	    }
}
