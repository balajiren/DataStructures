package ArrayQuestions;

import java.util.ArrayList;

public class SumArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1= new int[]{9,1,1};
		int[] arr2= new int[]{7,1,1};
		SumArrays(arr1,arr2);

	}
	
	public static int Sum(int a, int b)
	{
		while(b!=0)
		{
			int c  = a & b;
			a = a ^ b;
			b = c << 1;
			
			
		
		}
		
		System.out.print(a);
		return a;
	}
	
	//9+6 = 15
	public static void SumArrays(int[] arr1, int[] arr2)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<arr1.length || i<arr2.length;i++)
		{
			
			int sum = Sum(arr1[i],arr2[i]);
			if(sum > 9)
			{
				result.add(Integer.valueOf(String.valueOf(sum).substring(1,2)));
				result.add(Integer.valueOf(String.valueOf(sum).substring(0,1)));
			}
			else
			{
				result.add(sum);
			}
			
		}
	
		
	}

}
