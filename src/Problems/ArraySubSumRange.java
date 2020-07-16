package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ArraySubSumRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[] { 1,4,2,6,2,8,9};
		String result = FindSubArrayRange(input, 4,9);
		System.out.println(result);

	}
	
	
	public static String FindSubArrayRange(int[] input, int low, int high)
	{
		
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		
		// 1 2 2 4 6 8 9
		Arrays.sort(input);

		int left = 0;
		int right = input.length -1;
		while(left < right)
		{
			
			if(input[right] >= high)
			{
				right--;
			}

			if(input[left]+input[right] > low && input[left]+input[right] < high)
			{
				result.put(input[left], input[right]);
				break;
			}
			
			else if(input[left] + input[right] >= high)
			{
				right --;
			}
			else if(input[left] + input[right] <= low)
			{
				left++;
			}
			

			
		}
		
	     Iterator<Integer> val = result.keySet().iterator();
	     StringBuilder build = new StringBuilder();
	     while(val.hasNext())
	     {
	    	 
	    	 Object value = val.next();
	    	 build.append(value.toString() + ":" + result.get(value).toString());
	    
	     }
	     
		return build.toString();
	}

}
