package ArrayQuestions;

public class ArrayDPSolutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MaximumSubArray();

	}
	
	//Time Complexity O(N)
	public static int MaximumSubArray()
	{
		int[] source = new int[]{1,3,-4,5,7};
		int length = source.length+1;
		int[] resultMatrix = new int[length];
		int sum = 0;
		
		for(int i=0;i<source.length;i++)
		{
			sum = Math.max(sum, source[i]+ sum);
		}
		
		/*for(int i=1;i<length;i++)
		{
			resultMatrix[i] = Math.max(resultMatrix[i-1]+source[i-1], source[i-1]);
		}
		int result = resultMatrix[0];
		for(int j=1;j<resultMatrix.length;j++){
			if(result < resultMatrix[j])
			{
				result =  resultMatrix[j];
			}
		} */
		System.out.print("Largest Sum: "+sum);
		return sum;
	}

}
