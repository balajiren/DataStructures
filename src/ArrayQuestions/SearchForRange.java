package ArrayQuestions;

import java.util.Arrays;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindRange(new int[]{5,7,7,8,8,10},8);

	}
	
	public static void FindRange(int[] nums, int target)
	{
		int[] result  = new int[2];
		GetRange(nums, result, 0, nums.length,target,0);
		System.out.println(Arrays.toString(result));
		
		
	}
	
	public static void GetRange(int[] nums, int[] result, int start, int end, int target, int position)
	{
		if(start > end)
		{
			return;
		}
		if(nums[start] == target && nums[end] == nums[start])
		{
			result[0] = start;
			result[1] = end;
			return;
			
		}
		while(start < end)
		{
			int mid = start + (end-start) / 2;
			if(nums[mid] > target)
			{
				GetRange(nums, result, start, mid-1,target,position+1);
			} else
			if(nums[mid] < target)
			{
				GetRange(nums, result, mid+1, end,target,position+1);
			} else
			{
				result[0] = mid;
				result[1] = mid;
				
				int t1 = mid;
				while(t1 > start && nums[t1] == nums[t1-1])
				{
					t1--;
					result[0] = t1;
				}
				int t2 = mid;
				while(t2 < end && nums[t2] == nums[t2+1])
				{
					t2++;
					result[1] = t2;
				}
				return;
				
			}
			 
			
		}
		
	}

}
