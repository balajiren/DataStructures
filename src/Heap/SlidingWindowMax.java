 package Heap;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = MinSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 2);
		System.out.println(Arrays.toString(result));

	}
	
	
	public static int[] MinSlidingWindow(int[] nums, int k) {
		if(nums.length == 0) {
			return new int[0];
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[nums.length-k+1];
		for(int i=0;i<nums.length;i++) {
			if(!queue.isEmpty() && queue.peekFirst() == i-k) {
				queue.poll();
			}
			if(!queue.isEmpty() && nums[queue.peekLast()] > nums[i]) {
				queue.removeLast();
			}
			queue.offer(i);
			if(i+1 > k) {
				result[i+1-k] = nums[queue.peek()];
			}
		}
		
		return result;
	}
	
	
	public int[] MaxSlidingWindows(int[] nums, int k)
	{
		// nums.length = 4 k = 2
		if(nums == null || nums.length == 0)
		{
			return new int[0];
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		 int[] result = new int[nums.length-k+1];
		
		for(int i=0;i<nums.length;i++)
		{
			
			if(!queue.isEmpty() && queue.peekFirst() == i-k)
			{
				queue.poll();
			}
			
			if(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
			{
				queue.removeLast();
			}

			queue.offer(i);
			
			
			if(i+1 > k)
			{
				result[i+1-k] = nums[queue.peek()];
			}

			
			
		}

		return result;
	}

}
