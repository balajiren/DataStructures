package ArrayQuestions;

import Common.Utils;

public class ArrayTest {

	public static void main(String[] args)
	{
		int[] arr = {2, 3, 6, 4, 6, 2, 4, 3, 6, 2, 4, 4, 2};
		System.out.print(FindOddOccurances(arr));
		
	}
	
	
	public static int  FindOddOccurances(int[] arr)
	{
		int result = 0;
		for(int element : arr)
		{
			result = result ^ element;
		}
		return result;
		
	}
	
	
}
