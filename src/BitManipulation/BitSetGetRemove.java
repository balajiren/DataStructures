package BitManipulation;

public class BitSetGetRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bits = GetBits(7);
		System.out.println(bits);
		
		Integer num = BitsToNumbers(bits);
		System.out.println(num);
		
		Integer turnedOffBit = TurnOffBit(15,4);
		System.out.println(turnedOffBit);

	}
	
	public static String GetBits(int n)
	{
		StringBuilder sb = new StringBuilder();
		while(n > 0)
		{
			sb.append(n%2);
			n = n/2;
		}
		return sb.reverse().toString();
	}
	
	public static int BitsToNumbers(String bits)
	{
		int len  = bits.length();
		int result = 0;
		for(int i=0;i<bits.length();i++)
		{
			result += Math.pow(2,i);
					
			
		}
		return result;
	}
	
	public int ToggleBit(int bitvector, int index)
	{
		int mask = 1 << index;
		if((bitvector & mask) == 0)
		{
			bitvector |=mask;
			
		} else
		{
			bitvector &= ~mask;
		}
		return bitvector;
	}
	
	
	public int CountSetBits(int n)
	{
		
		return n & 1;
	}
	
	public static boolean GetBit(int num, int i)
	{
		return (num & (1<<i)) == 0;
	}
	
	public static int TurnOffBit(int n, int k)
	{
		return (n & ~(1<< (k-1)));
	}

}
