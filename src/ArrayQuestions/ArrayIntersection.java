package ArrayQuestions;

import java.util.Arrays;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindIntersection();

	}
	
	
	public static void FindIntersection()
	{
		int[] arr1 = new int[]{1,4,8,7,9};
		int[] arr2 = new int[]{1,5,6,9,109};
	
		int[][] dparr = new int[arr1.length][arr2.length];
		int x=0 ;int y = 0;
		while(x < arr1.length && y < arr2.length)
		{
			if(arr1[x] == arr2[y])
			{
				System.out.print(arr1[x]);
				x++;
				y++;
			}
			else if(arr1[x] > arr2[y])
			{
				y++;
			}
			else if(arr1[x] < arr2[y])
			{
				x++;
			}
		}

		//System.out.print(Arrays.deepToString(dparr));
	
		
		
	}

}
