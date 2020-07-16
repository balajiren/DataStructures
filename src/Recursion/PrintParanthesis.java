package Recursion;

public class PrintParanthesis {

	public PrintParanthesis() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintParanthesis(2,2,"");
	}
	
// 4pown/sqrt(n) => time and space complexity
	public static void PrintParanthesis(int open, int close, String input)
	{
		
		if( open ==0 &&  close ==0)
		{
			System.out.println(input);
			
		}
		if(open > close)
		{
			return;
		}
		if(open > 0)
		{
			PrintParanthesis(open -1 , close, input + "(");
		}
		
		if(close > 0)
		{
			PrintParanthesis(open , close  - 1, input + ")");
		}
		
	}

}
