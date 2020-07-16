	package ArrayQuestions;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray(new int[]{1,2,3,4,5,6}, 2);

	}
	
	public static void RotateArray(int[] arr, int order)
	{
		int orderstart = arr.length - order;
		ReverseArray(arr,0, orderstart-1);
		ReverseArray(arr,orderstart, arr.length-1);
		ReverseArray(arr,0, arr.length-1);
		
		System.out.print(Arrays.toString(arr));
		
	}
	
	public static void ReverseArray(int[] arr, int left, int right)
	{
		if(arr.length == 0)
		{
			return;
		}
		while(left < right)
		{
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;;
			left++;
			right--;
		}
	}
	
	//MIN IN ROTATED ARRAY
	public int findMin(int[] nums) {
	    if(nums==null || nums.length==0)
	        return -1;
	 
	    int i=0; 
	    int j=nums.length-1;
	 
	    while(i<=j){
	        if(nums[i]<=nums[j])
	            return nums[i];
	 
	        int m=(i+j)/2;
	 
	        if(nums[m]>=nums[i]){
	            i=m+1;
	        }else{
	            j=m;
	        }
	    }
	 
	    return -1;
	}

}
