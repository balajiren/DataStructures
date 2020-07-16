package Recursion;
import java.util.*;

public class PrintFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//8
	//8/1
	//8/2 =  4 /2  2/2
	public List<List<Integer>> PrintFactors(int start, int product, int n, List<Integer> temp, List<List<Integer>> result)
	{
		if(start>n || product > n )
	        return result;
		
		if(product == n)
		{
			ArrayList<Integer> t = new ArrayList<Integer>(temp);
			result.add(temp);
		}
		for(int i=start;i < n ;i++)
		{
			if (n / i == 1) {
				return result;
			}
			if( i > 1)
			{
				if(n % i == 0)
				{
					temp.add(n);
					PrintFactors(i, i * product, n, temp, result);
					temp.remove(temp.size()-1);
				}
			}		
			
		}
		
		
		return result;
	}

}
