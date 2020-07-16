package Recursion;
import java.util.*;
import java.util.Arrays;

public class GenerateBitSequence {
	
	
	static int[] arrA = new int[3];
	public static void main(String args[])
	{
		 //nBits(3);
		 generate("??1");
		
	}
	
	public static void nBits(int n)
	{
		if(n <= 0)
		{
			System.out.println(Arrays.toString(arrA));
		}
		else
		{
		arrA[n-1] = 0;
		nBits(n-1);
		
		arrA[n-1] = 1;
		nBits(n-1);
		}
		
		
		
		
	}
	
	public static LinkedList<String> generate(String pattern) {
		
		LinkedList<String> strings = new LinkedList<String>();
		int pos = pattern.indexOf("?");
		if(pos < 0) {
			System.out.println(pattern);
			strings.add(pattern);
		} else {
			String zeroPattern = pattern.substring(0, pos) + "0" + pattern.substring(pos+1);
			String onePattern = pattern.substring(0, pos) + "1" + pattern.substring(pos+1);
			strings.addAll(generate(zeroPattern));
			strings.addAll(generate(onePattern));
		}
		return strings;
	}

}
