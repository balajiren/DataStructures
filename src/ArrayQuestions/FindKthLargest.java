package ArrayQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[]{1,2,4,6,2,10};
		int result = FindKthSmallest(input, 2);
		System.out.println(result);
	}
	

	
	//Quick Sort O(N) Worst case: O(Npow2)
	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public static int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	
	//OLOGN - NAIVE
	public static int FindKthSmallest(int[] input, int k)
	{
		//maxheap is the default
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(input.length,Collections.reverseOrder());
		for(int i=0; i< input.length; i++)
		{
			que.offer(input[i]);
			if(que.size() > k)
			{
				que.poll();
			}
			
			
		}
		int result = que.peek();
		return result;
		//System.out.println(result);
		
		
	}
	
}
