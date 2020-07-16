package Recursion;

public class PrintNCombinationDigits {

	public static void main(String[] args) {
		
		 int[] digits = new int[] {1,2,3};
		// TODO Auto-generated method stub
		PrintCombinations(0,0,7,digits);

	}
	
 
	public static void PrintCombinations(int lastDigit, int currentstep,int iter,  int[] numDigits)
	{
		int i;
		if(iter == 0)
		{
			System.out.print(lastDigit + "\n");
			return;
		}
		
		PrintCombinations(lastDigit * 10 + numDigits[0],currentstep,iter-1,numDigits);
		for(i = currentstep+1;i<numDigits.length;i++)
		{
			PrintCombinations(lastDigit * 10 + numDigits[i], currentstep, iter-1,  numDigits);
		}
		
		
		
				
	}


	

}
