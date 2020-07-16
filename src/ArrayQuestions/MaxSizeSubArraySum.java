package ArrayQuestions;
import java.util.*;

public class MaxSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = MaxSizeSubArraySum(new int[] { 1, -1, 5, -2, 3}, 3);
		System.out.println(result);

	}
	
	
	static int maxSubArraySum(int a[], int size)
    {
	    int max_so_far = a[0];
	    int curr_max = a[0];
	 
	    for (int i = 1; i < size; i++)
	    {
	           curr_max = Math.max(a[i], curr_max+a[i]);
	           max_so_far = Math.max(max_so_far, curr_max);
	    }
	    return max_so_far;
    }
	
	public static int MaxSizeSubArraySum(int[] nums, int k)
	{
		int maxlen = 0;
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		
		int j = 0;
		int sum = 0;
		
	    for(int i=0; i<nums.length; i++)
		{
			sum+= nums[i];
            j++;
			if(sum == k)
			{
				int len = i;
				maxlen = Math.max(maxlen, len);
			}
			int diff = sum - k;
			if(m.containsKey(diff))
			{
				maxlen =  Math.max(maxlen, i - m.get(diff));
				
			} 
			if(!m.containsKey(sum))
			{
				m.put(sum, i);
			}
			
			
		 }

		return maxlen;
		
	    }
	
}
	    
	 
	    
	    

