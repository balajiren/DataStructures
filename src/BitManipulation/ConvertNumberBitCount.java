package BitManipulation;

public class ConvertNumberBitCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int CountBits(int a, int b)
	{
		int count = 0;
		for(int c = ( a ^ b); c!=0;c= c & (c-1))
		{
			count++;
		}
		
		return count;
	}

}
