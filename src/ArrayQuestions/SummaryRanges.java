package ArrayQuestions;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = SummaryRange(new int[]{0,1,2,4,5,7});

	}
	
	public static String SummaryRange(int[] nums)
	{
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		int prev = nums[0];
		while(i <= nums.length-1)
		{
			
			if(i+1 < nums.length)
			{
				int current = nums[i+1];
				if(current - prev == 1)
				{				
					prev = current;

				}
				else
				{
				
					sb.append(nums[j] + "-->" + prev + "-->");
					j = i+1;
					prev = nums[j];
					
					
			
				}
		        
				
			}
			else
			{
				sb.append(nums[i]);
				break;
			}
			i++;
			
		}
		System.out.println(sb.toString());
		return sb.toString();
		
	}

}
