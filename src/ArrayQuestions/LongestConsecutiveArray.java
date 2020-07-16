package ArrayQuestions;
import java.util.*;

public class LongestConsecutiveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestConsecutiveArray(new int[] {4,1,4,5,6,7,9}));

	}
	
	public static int LongestConsecutiveArray(int[] input)
	{
		int longest = 0;
		
		int start = 0;
		int end =  1;
		
		for(int i=0;i<input.length;i++)
		{
			if(end == input.length)
			{
				return longest;
			}
			if(input[end] > input[start] && input[end] - input[end-1] ==1)
			{
				end++;
			}
			else {
				start++;
				end++;
			}
			if(end - start > 0)
			{
				longest = Math.max((end - start), longest);
			}
		}
		  return longest;
	
		
	}

}
