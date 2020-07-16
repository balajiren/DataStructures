package BitManipulation;

public class BitProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sum(1, 2);
		//IntegerToBinary(60);
		int res = GetProduct(2);
		System.out.println(res);

	}
	
	public static boolean IsEven(int number)
	{
		return (number & 1) == 0;
	}
	
	public static int GetProduct(int number)
	{
		return (number << 1);
	}
	
	public static void printBinaryFormat(int number){
	        int binary[] = new int[25];
	        int index = 0;
	        while(number > 0){
	            binary[index++] = number%2;
	            number = number/2;
	        }
	        //System.out.println(Arrays.toString(binary));
	        for(int i = index-1;i >= 0;i--){
	            System.out.print(binary[i]);
	        }
	    }
	
	public static String ConvertToBinary(int n)
	{
		StringBuilder sb = new StringBuilder();
		while(n > 0)
		{
			int c = n % 2;
			sb.append(String.valueOf(c));
			n  = n/2;
			
		}
		System.out.println(sb.reverse());
		return sb.toString();
	}
	
	
	public static void IntegerToBinary(int number)
	{
		
		System.out.println(Integer.toBinaryString(number));
		
		
	}
	
	public static void BinaryLogical(int number, int number2)
	{
		
		int res = number ^ number2;
		
		System.out.println(Integer.toBinaryString(res));
		
		
	}
	
	public static int Sum(int a, int b)
	{
		while(b!=0)
		{
			int c  = a & b;
			a = a ^ b;
			b = c << 1;
	
		}
		System.out.print(a);
		return a;
	}
	
	public int divide(int dividend, int divisor) {
	    //handle special cases
	    if(divisor==0) return Integer.MAX_VALUE;
	    if(divisor==-1 && dividend == Integer.MIN_VALUE)
	        return Integer.MAX_VALUE;
	 
	    //get positive values
	    long pDividend = Math.abs((long)dividend);
	    long pDivisor = Math.abs((long)divisor);
	 
	    int result = 0;
	    while(pDividend>=pDivisor){
	        //calculate number of left shifts
	        int numShift = 0;    
	        while(pDividend>=(pDivisor<<numShift)){
	            numShift++;
	        }
	 
	        //dividend minus the largest shifted divisor
	        result += 1<<(numShift-1);
	        pDividend -= (pDivisor<<(numShift-1));
	    }
	 
	    if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        return result;
	    }else{
	        return -result;
	    }
	}
	

	
	public int singleNumber(int[] A) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}

}
