	package Recursion;

public class ProductOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minProduct(35, 30);
	}
	
	
	public static void minProduct(int a, int  b)
	{
		int bigger =  a > b ? a : b;
		int smaller  = b < a ? b : a;
		
	 System.out.println(minProductRecursive(smaller, bigger));
	
		
	}
	
	public static int minProductRecursive(int smaller, int bigger)
	{
		
		if(smaller == 0) {
			return 0;
		}
		else if(smaller == 1) {
			return bigger;
		}
		//divide by 2
		
		int s = smaller >> 1;
		int halfProduct = minProductRecursive(s, bigger);
		if(halfProduct % 2 == 0)
		{
			return halfProduct+halfProduct;
		} else
		{
			return halfProduct+halfProduct+bigger;
		}
		
		
	}
	

}
