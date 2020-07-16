package Number;

public class NumberOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int addDigits (int num)
	{
		int sum=0;
		 
	    String s = String.valueOf(num);
	    for(int i=0; i<s.length(); i++){
	        sum = sum + (s.charAt(i)-'0');
	    }
	 
	    if(sum < 10){
	        return sum;
	    }else{
	        return addDigits(sum);
	    }
		
		
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

}
