package Number;

public class ReverseNumber {

	//123 //3 //12.3 30+2 32
	
	public int Reverse(int n)
	{
		int rev =0;
		
		while(n != 0)
		{
			rev = rev * 10 + n % 10;
			n = n / 10;
			
		}
		return rev;
		
		
	}
	
	

}
