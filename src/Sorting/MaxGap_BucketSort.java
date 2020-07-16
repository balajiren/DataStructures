package Sorting;

class Bucket
{
	
	int low = -1;
	int high = -1;
	Bucket()
	{
		
	}
	
}

//Bucket Sort
public class MaxGap_BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 1 3 8 12 15
	public int FindMaxGap(int[] nums)
	{
		int max = -1;
		int min = -1;
		for(int i=1; i<nums.length; i++){
	        max = Math.max(max, nums[i]);
	        min = Math.min(min, nums[i]);
	    }
	 
		Bucket[] bucket = new Bucket[nums.length];
		
		for(int i=0;i<nums.length;i++)
		{
			bucket[i] = new Bucket();
		}
		int interval = nums.length / (max-min);
		for(int i : nums)
		{
			int index = (i - min) * interval;
			if(bucket[index].low!=-1)
			{
				bucket[index].low = i;
				bucket[index].high = i;
				
			} else
			{
				bucket[index].low = Math.min(bucket[index].low, i);
				bucket[index].high = Math.min(bucket[index].high, i);
				
			}
			
			
		}
		
		//scan buckets to find maximum gap
	    int result = 0;
	    int prev = bucket[0].high;
	    for(int i=1; i<bucket.length; i++){
	        if(bucket[i].low != -1){
	            result = Math.max(result, bucket[i].low-prev);
	            prev = bucket[i].high;
	        }
	 
	    }
		
		
		return result;
		
	}

}
