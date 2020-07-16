package Problems;

import java.util.Arrays;

public class FindMaxMergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] in = new int[]{1, 2, 10, 5, 5};
		int[] out = new int[]{4, 5, 12, 9, 12};
		FindMaxGuests(in,out);

	}
	
	//http://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
	public static void FindMaxGuests(int[] in, int[] out)
	{
		
		int n = in.length;
		int[] sorted = new int[n+out.length];
		
		Arrays.sort(in);
		Arrays.sort(out);
		int i=1 , j= 0 ;
		 int guest = 1, max_guests = 1, time = in[0];
		
		while(i < n && j < n)
		{
			if(in[i] <= out[j])
			{
				guest++;
				
	          // Update max_guests if needed
		          if (guest > max_guests)
		          {
		              max_guests = guest;
		              time = in[i];
		          }
		          i++;
				//sorted[k++] = in[i++];
				
			}
			
			else
			{
				guest--;
				j++;
				//sorted[k++] = out[j++];
			
			}
			
			
		}
		/*while(i < n)
		{
			sorted[k++] = in[i++];
		}
		
		while(j < out.length)
		{
			sorted[k++] = out[j++];
		} */
				
		System.out.println("Max guests"+guest+"at"+time);
		
		
	}

}
