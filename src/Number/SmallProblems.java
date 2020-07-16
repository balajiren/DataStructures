package Number;

import Common.Utils;

public class SmallProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FindNonRepeatingNumber(new int[]{1,3,3,3,1,1,2});
		//boolean flag = IsPowerOfTwo(8);
		//System.out.println(ReverseNumber(987));

		System.out.println(floorSqrt(987));
	}
	public static int FindNonRepeatingNumber(int[] numbers)
	{
		int ones=0, twos=0, threes = 0;
		for(int i=0;i<numbers.length;i++)
		{
	
			twos |= ones & numbers[i];
			ones = ones ^ numbers[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
	    System.out.print(ones);
		return ones;
	}
	
	
	public static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
 
        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
 
            // If x is a perfect square
            if (mid*mid == x)
                return mid;
 
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }
	
	
	public static boolean IsPowerOfTwo(int n)
	{
		return (n & n -1) == 0;
	}
	
	public static int PrintFibonacci(int n)
	{
      int[] result  = new int[n+1];
	  if(n == 0)
	  {
		  return 0;
	  }
	  else
	  {
	
		   result[0]= 0;
		   result[1] = 1;
		   for(int i=2; i<=n;i++)
		   {
			   
			   result[i] = result[i-1]+result[i-2];
			   
		   }
			   
	  }
	    System.out.print(result[n]);
		return result[n];
		
	}
	
	public static int ReverseNumber(int x)
	{
		int rev = 0;

			while(x != 0)
			{
				rev = rev * 10 + x % 10;
				x = x /10;
			}

		
	    System.out.print(rev);
		return rev;
	}

}
