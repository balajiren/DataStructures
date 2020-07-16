package BitManipulation;

public class NumberArithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res = PrintSum(99,4);
		System.out.println(res);

	}

public static int PrintSum(int a, int b)
{
	
	while(b!=0)
	{
		int c  = a & b ;
		a = a ^ b;
		b = c << 1;
		
	}
	
	return a;
}

	//Function for multiplication
	int multiply(int n, int m)
	{  
	 int ans = 0, count = 0;
	 while (m > 0)
	 {
	     // check for set bit and left 
	     // shift n, count times
	     if (m % 2 == 1)              
	         ans += n << count;
	
	     // increment of place value (count)
	     count++;
	     m /= 2;
	 }
	 return ans;
	}


}