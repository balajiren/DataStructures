package Number;
import java.util.*;

import Common.Utils;

public class EulerNumberProblems {

	public static void main(String[] args) {
		LongestPrimeFactor(600851475143l);

	}
	
	public static void LongestPrimeFactor(long number)
	{
		long result = number;
		int counter =2;
		long longestFactor= 0;
		while(counter * counter <= result)
		{
			if(result % counter == 0)
			{
				result /=counter;
				longestFactor= counter;
			}
			else
			{
				counter++;
			}
	
		}
		if(result > longestFactor)
		{
			longestFactor = result;
		}
		Utils.PrintMessage(String.valueOf(longestFactor));
	}

}
