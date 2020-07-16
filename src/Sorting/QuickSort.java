package Sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =new int[]{ 3,6,1,8,2,5,9,2,3};
		int k = 2;
		
		QuickSort( nums, 0,nums.length-1);
		System.out.print(Arrays.toString(nums));

	}
	
	public static void swap(int[]nums, int left, int right)
	{
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
	public static void QuickSort(int[]nums, int start, int end)
	{
		int pivot = nums[end];
		int i = start;
		int j = end;
		
		while(i<=j)
		{
			
			while(nums[i] < pivot)
			{
				i++;
			}
			
			while(nums[j] > pivot)
			{
				j--;
			}
		
			if(i <=j)
			{
				swap(nums,i,j);
				i++;
				j--;
			}
			
		
		}
		
		if(start < j)
		{
			QuickSort(nums, start, j);
		}
		if(end > i)
		{
			QuickSort(nums, i, end);
		}

		
	}

}
