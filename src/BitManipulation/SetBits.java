package BitManipulation;

public class SetBits {

	public static void main(String[] args) {
		
		 PrintBinary(100);
		
	}

	public boolean getBit(int num, int i)
	{
		
		return (num & 1 << i)!=0;
	}
	
	public int setBit(int num, int i)
	{
		return num | 1 << i;
	
	}
	
	public static void PrintBinary(double num)
	{
		StringBuilder builder = new StringBuilder();
		while(num > 0)
		{
		        double r = num * 2;
		        if( r >= 1)
		{
		   builder.append("1");
		   num = r - 1;
		}
		 else
		{    
		   builder.append("0");
		   num = r;
		}
	
		}

        System.out.println(builder.toString());
	}
}
