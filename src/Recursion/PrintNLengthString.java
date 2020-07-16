package Recursion;

public class PrintNLengthString {

	public PrintNLengthString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String k = "ALGO";
		int n = 2;
		PrintNLength(n, k.toCharArray(), new char[n]);

	}
	
	public static void PrintNLength(int n, char[] input, char[] result)
	{
		
		if(n <= 0)
		{
			System.out.print(String.valueOf(result) + " ");
		}
		
		else
		{
			for(int i=0;i<input.length;i++)
			{
				result[n-1] = input[i];
				PrintNLength(n-1,input,result);
				
			}
		}
		
		
	}
	

}
