package Problems;

public class FindMaxInTriangularRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "5#9#6#4#6#8#0#7#1#5";
		int result = LargestSum(input);

	}
	
	
	public static int LargestSum(String input)
	{
		int largest = 0;
		int total=0;
		String[] str = input.split("#");
		int maxComparision = 0;
		int i=0;
		for(i=0;i<=str.length;i = maxComparision+i)
		{
			
		
			
			largest = Math.max(largest,Integer.parseInt(str[i]));
			
			if(i == maxComparision)
			{
				total+=largest;
				largest =0;
			}
			
			
			maxComparision = maxComparision+i;
			
		}
		
		
		return total;
		
	}
     
}
