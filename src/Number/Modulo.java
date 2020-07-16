package Number;

public class Modulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		modulo(2,5,3);
	}
	
	
	public static int modulo(int a,int b,int c) {
	    long x=1;
	    long y=a;
	    while(b > 0){
	        if(b%2 == 1){
	            x=(x*y)%c;
	        }
	        y = (y*y)%c; // squaring the base
	        b /= 2;
	    }
	    return (int) x%c;
	}

}
