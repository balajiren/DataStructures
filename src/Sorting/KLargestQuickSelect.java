package Sorting;

import java.util.Arrays;

public class KLargestQuickSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[]{3,7,1,6,8};
		int result  = findKthSmallest(nums,2);
		System.out.println(result);

	}
	
	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	
	public static int findKthSmallest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
		return getKth(k, nums, 0, nums.length - 1);
	}
	
	public static int getk1(int k, int[] nums, int start, int end)
	{
		
		int pivot = nums[end];
		int left = start;
		int right = end;
		while(true) {
			
			while(nums[left] < pivot && left < right) {
				left++;
			}
			while(nums[right] >= pivot && left < right) {
				right--;
			}
			if(left == right) {
				break;
			}
			swap(nums,left,right);
		}
		swap(nums,left,end);
		if(k == left+1) {
			return pivot;
		} else if( k < left+1)
		{
			return getk1(k,nums,start,left-1);
		} else
		{
			return getk1(k,nums,left+1,end);
		}
		
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
		System.out.println(Arrays.toString(nums));
	 
		//make the left as end for pivot selection 
		// end will become left
		swap(nums, left, end);
	 
		System.out.println(Arrays.toString(nums));
		
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

}
