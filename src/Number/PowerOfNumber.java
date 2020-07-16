package Number;

public class PowerOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double res = myPow(2,2);
		System.out.println(res);

	}

    static float myPow(float x, int y) {
    	float temp;
        if( y == 0)
           return 1;
        temp = myPow(x, y/2);       
        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
 }
 
 
 public boolean isPowerOfTwo(int n) {
	    return n>0 && (n&n-1)==0;
	}
 

}
