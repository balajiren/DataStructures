package DynamicProgramming;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int Candy(int[] ratings)
	{
		
		int[] candies = new int[ratings.length];
		int min=0;
		candies[0] = 1;
		//scan from left
		for(int i=1;i<ratings.length;i++)
		{
			if(ratings[i] > ratings[i-1])
			{
				candies[i] = candies[i-1] + 1;
			} else
			{
				candies[i] = 1;
			}
	
		}
		int result = candies[ratings.length-1];
		
		for(int i=ratings.length-2;i>=0;i--)
		{
			int cur = 1;
			if(ratings[i] > ratings[i+1])
			{
				cur = candies[i+1] + 1;
			} 
			result +=Math.max(cur, candies[i]);
			candies[i] = cur;
	
		}
		return result;
	}

}
