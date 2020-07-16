package ArrayQuestions;

public class Sliding_MaxSubArrayOfKElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[]{1,3,4,8,2,5,6,11};
		int res = MaxSubArrayOfKElements(arr,2);
		System.out.print(res);

	}
	
	public static int MaxSubArrayOfKElements(int[] input, int k)
	{
		 if(k > input.length)
		{
		   return -1;
	
		}
		int sum = 0;
		for(int i=1;i<k;i++)
		{
		  sum+=input[i];
	
		}
		int maxSum = sum;
		int maxSumIndex =0;
		for(int j=k;j<input.length;j++)
		{
		  sum  = sum - input[j-k];
		  sum = input[j];
		  maxSum = Integer.max(maxSum,sum);
		  maxSumIndex = j-k;
	
		}
	    
		return maxSumIndex + 1;
		}

}
