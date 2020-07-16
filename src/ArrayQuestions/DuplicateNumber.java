package ArrayQuestions;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = FindDuplicate(new int[] { 3,5,6,1,3,4});
		System.out.print(res);

	}
	
	public static int FindDuplicate(int[] nums)
	{
		int l = 0;
		int r = nums.length-1;
		int c = 0;
		while(l < r)
		{
			int m = (l+r)/2;
			for(int i : nums)
			{
				if(i <= m)
				{
					c++;
				}
			}
			if(c > m)
			{
				r = m;
			} else
			{
				l = m+1;
			}
			
			
		}
		return r;

	}

}
