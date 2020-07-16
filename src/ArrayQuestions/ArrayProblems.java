package ArrayQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.rmi.CORBA.Util;

import Common.Utils;

public class ArrayProblems {

	public static void main(String[] args)
	{
		int[] arr1 =  new int[] {5, 4, 3,2,3,4,1};
		int[] arr2 =  new int[]  {2, 13, 17, 30, 45};
		
		//boolean result = FindIncreasingTriplet(arr1);
		//System.out.print(result);
		
		int result = FindMinRotatedArray(new int[]{4, 5 ,6 ,7, 2 ,4 ,5});
		System.out.print(result);
		
	}
	
	
	public int FindMedianOfSorted(int[] nums1, int[]nums2)
	{
		int totallength = nums1.length + nums2.length;
		if(totallength % 2 == 1)
		{
			return FindMedian(totallength/2+1, nums1, nums2, 0,0);
		} else
		{
			return (FindMedian(totallength/2, nums1, nums2, 0,0) + FindMedian(totallength/2+1, nums1, nums2, 0,0))/2;
		}
		
	}
	
	//new int[]{4 5 6 7 1 3 2}
	public static int FindMinRotatedArray(int[] nums)
	{
		int result = 0;
		int start= 0;
		int end  = nums.length-1;
		while(start < end)
		{
			int mid = (start+end)/2;
			if(nums[mid] <= nums[start])
			{
			    result = nums[mid];
			} 
			if(nums[mid] > nums[start])
			{
			  start = mid-1;

			} else
			{
				end = mid;
			}
			start++;
			end--;
		
		}
		return result;
	}
	
	public static int FindMedian(int k, int[] nums1, int[] nums2, int s1, int s2)
	{
		if(s1 >= nums1.length)
		{
			return nums2[s2+k-1];
		}
		if(s2 >= nums1.length)
		{
			return nums1[s1+k-1];
		}
		if(k == 1)
		{
			return Math.min(nums1[s1], nums2[s2]);
		}
		int mid1 = s1 + k/2 -1;
		int mid2 = s1 + k/2 -1;
		int m1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
		int m2 = mid2 < nums1.length ? nums2[mid2] : Integer.MAX_VALUE;
		if(m1 < m2)
		{
			return FindMedian(k/2, nums1, nums2,mid1+1, s2);
		} else
		{
			return FindMedian(k/2, nums1, nums2, s1,mid2+1);
		}
		
		
		
		
	}
	
	
	public static int FindPeakElement(int[] nums)
	{
		 int i = 0;
		 int j = 1;
		 while(i < j)
		 {
			 if(nums[j] > nums[i] && nums[j] > nums[j+1])
			 {
				 return nums[j];
			 }
			 i++;
			 j++;
			
			 
		 }
	     return 0;
		
	}
	
	public static int FindMajorityElements(int[] input)
	{
		Map<Integer,Integer> se = new HashMap<Integer,Integer>();
		int result = 0 ;
		int count = 0;
		for(int i : input)
		{
			if(count == 0)
			{
				result = i;
				count = 0;
			} else 
			if(i == result)
			{
				count++;
			} else
			{
				count--;
			}
		}

		return result;
	}
	
	public static int FindMissingWithZero(int[] input)
	{
		int n = input.length;
		for(int i=0;i<input.length;i++)
		{
			while(input[i] !=i)
			{
				if(input[i] < 0 || input[i] >= n)
				{
					break;
				}
				if(input[i] == input[input[i]])
				{
					break;
				}
				//swap elements
				int temp = input[i];
				input[i] = input[temp];
				input[temp] = temp;
				
			}
			for(int missing=0;missing<input.length;missing++)
			{
				if(input[missing]!=missing)
				{
					return missing;
				}
			}
			
			
		
			
			
			
		}
		return n;
		
		
	}
	
	public static boolean FindIncreasingTriplet(int[] nums)
	{
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
	 
		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
	 
			if (x >= z) {
				x = z;// update x to be a smaller value
			} else if (y >= z) {
				y = z; // update y to be a smaller value
			} else {
				return true;
			}
		}
	 
		return false;
	}
	
	public static int FindMissingPositiveWithNoZero(int[] input)
	{
		int n = input.length;
		for(int i=0;i<input.length;i++)
		{
			while(input[i] !=i+1)
			{
				if(input[i] < 0 || input[i] >= n)
				{
					break;
				}
				if(input[i] == input[input[i]-1])
				{
					break;
				}
				int temp = input[i];
				input[i] = input[temp-1];
				input[temp-1] = temp;
				
				
				
			}
		}
		for(int i : input)
		{
			if(input[i] !=i+1)
			{
				return i+1;
			}
		}
		return n+1;
	}
	

	
	public static int FindMedianOfSortedArrays(int[] arr1, int[] arr2)
	{
	 // System.arraycopy(src, srcPos, dest, destPos, length);
		int arr1len = arr1.length;
		int arr2len = arr2.length;
		if(arr1len == 0 && arr2len > 1)
		{
			return arr2[arr2len/2];
		}
		else if(arr2len == 0 && arr1len > 1)
		{
			return arr2[arr2len/2];
		}
	
		return FindMedian(arr1, arr1[0], arr1[arr1len-1], arr2,  arr2[0], arr1[arr2len-1]);
		
	}
	
	public static int FindMedian(int[] arr1, int arr1Start, int arr1End, int[]arr2, int arr2start, int arr2End)
	{
		int median1 = (arr1Start + arr1End)/2;
		int median2 = (arr2start + arr2End)/2;
		
		if(arr1End -  arr1Start== 1)
		{
			return (Math.max(arr1Start, arr2start)+Math.min(arr1End, arr2End))/2;
		}
		
		if(median1 > median2)
		{
			return FindMedian(arr1, arr1Start,  median1, arr2,  median2,  arr2End);
			//then element is in first half and second last half
		}
		else 
		{
			//element is in last half of first and first half of second
			return FindMedian(arr1, median1,  arr1End, arr2,  arr2start,  median2);
		}
	}
	
	
	//O(NLogn): Time complexity
	public static int MagicIndex(int[] input, int start, int end)
	{
	   int mid =(start + end) /2 ;
	   if(input[mid] == mid)
	   {
	       return mid;
	   }
	   if(mid  > input[mid])
	   {
	       
	       return MagicIndex(input, mid+1, end);
	   }
	    if(mid < input[mid])
	   {
	       
	       return MagicIndex(input, 0, mid-1);
	   }
	   
	   return -1;
	}
	
	//Time Complexity(nlogn)
	public static int FindKLargestElement()
	{
		int k = 3;
		int[] arr1 = {12, 15, 1, 26, 38};
		Arrays.sort(arr1);
		return arr1[arr1.length - k];
		
	}
	
	
	//Time Complexity(nlogn)
	public static int FindKLargestElementUsingHeap()
	{
		int k = 3;
		int[] arr1 = {15, 1, 12, 26, 38};
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for(int i: arr1)
		{
			queue.offer(i);
		
			if(queue.size() > k)
			{
				queue.poll();
			}
			
		}
	    
		return queue.peek();
	}
	
	//O(1) Space complexity 
	public static void RotateArray()
	{
		int[] arr1 = {1, 12, 15, 26, 38};
		int k = 3;
		
		if(k < 0)
		{
			 throw new IllegalArgumentException("k cannot be negative!");
		}
		if(arr1==null || arr1.length == 2)
		{
			return;
		}
		int n = arr1.length;
		if(k > n)
		{
			k = k % n;
		}
		reverseElements(arr1, 0, k-1);
		reverseElements(arr1, k, n-1);
		reverseElements(arr1, 0, n-1);
		
		System.out.println(Arrays.toString(arr1)); 

	}
	
	public static void PrintLeadersInArray()
	{
		int[] arr1 = {1, 12, 15, 26, 38};
		int max = arr1[arr1.length-1];
		
		for(int i=arr1.length -1 ; i>=0;i--)
		{
			if(arr1[i] >= max)
			{
				max = arr1[i];
				System.out.print(max);
			}
		}
		
	}
	
	// Reverse an array between start (s) and end (e)
    private static void reverseElements(int[] array, int start, int end)
    {
    	while(start < end)
    	{
    		int temp = array[start];
    		array[start] = array[end];
    		array[end] = temp;
    		start++;
    		end--;
    		
    	}
    	
    }
    
    
    public static void MegeSortedArrays()
    {
    	 int INVALID_NUM = 0;
    	 int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
         int[] arrayB = {-1, 2, 6, 12};
    	
    	  // move all elements of arrayA with valid values towards the end
        int validNumIndex = arrayA.length - 1;
        for (int i = arrayA.length - 1; i >= 0; i--)
        {
            if (arrayA[i] != INVALID_NUM)
            {
                arrayA[validNumIndex] = arrayA[i];
                validNumIndex -= 1;
            }
        }
         
        // i: index of first valid valued element in arrayA
        int i = validNumIndex + 1;
        int j = 0, k = 0;
         
        // fill-up arrayA starting from 0th index since this end of arrayA is free now
        while ((i < arrayA.length) && (j < arrayB.length))
        {
            if (arrayA[i] < arrayB[j])
            {
                arrayA[k++] = arrayA[i++];
            }
            else
            {
                arrayA[k++] = arrayB[j++];
            }
        }
         
        // copy any remaining elements of smaller array into larger one 
        while (j < arrayB.length)
        {
            arrayA[k++] = arrayB[j++];
        }
        
        for (int COUNT = 0;  COUNT < arrayA.length; COUNT++)
        {
            System.out.print(arrayA[COUNT] + ", ");
        }
    	
    }
    
    public static int longestConsecutive(int[] num) {
    	// if array is empty, return 0
    	if (num.length == 0) {
    		return 0;
    	}
     
    	Set<Integer> set = new HashSet<Integer>();
    	int max = 1;
     
    	for (int e : num)
    		set.add(e);
     
    	for (int e : num) {
    		int left = e - 1;
    		int right = e + 1;
    		int count = 1;
     
    		while (set.contains(left)) {
    			count++;
    			set.remove(left);
    			left--;
    		}
     
    		while (set.contains(right)) {
    			count++;
    			set.remove(right);
    			right++;
    		}
     
    		max = Math.max(count, max);
    	}
     
    	return max;
    }

    
     
	
}
