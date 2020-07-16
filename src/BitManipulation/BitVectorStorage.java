package BitManipulation;

public class BitVectorStorage {

	
	public static void main(String[] args)
	{
		
		
		findOpenNumber();
		
		
	}
	
	
	static long numInts = (long)Integer.MAX_VALUE+1;
	static byte[] bitfield = new byte [(int)(numInts/8)];
	
	static void findOpenNumber() 
	{
		int n= 10;
		for(int i=0;i<n;i++)
		{
		  bitfield[n/8] |= 1<< (n%8);
		}
		
		for(int i=0;i<bitfield.length;i++)
		{
			for(int j=0;j<8;j++)
			{
				if((bitfield[i] & (1<<j)) == 0)
				{
					System.out.println(i*8+j);
					return;
				}
				
			}
			
			
		}
		
	}
	
	
	
	
	
}
