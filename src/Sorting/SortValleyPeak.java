package Sorting;

public class SortValleyPeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findPeakIndex(int a, int b, int c, int[] nums)
	{
		int greaterIndex = Math.max(nums[c],Math.max(nums[a],nums[b]));
		return greaterIndex;
		
		
	}
	
	public void sortValleyPeak(int[] nums)
	{
		
		for(int i=1;i<nums.length;i++)
		{
			int peakIndex = findPeakIndex(i-1,i,i+1,nums);
			//swap(nums,i,peakIndex);
			
			
			
		}
		
		
		
		
	}

}
