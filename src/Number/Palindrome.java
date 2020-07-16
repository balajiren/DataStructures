package Number;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IsPalindrome(999);

	}
	
	public static boolean IsPalindrome(int number)
	{
		
		//get number of zeros
		int div =1;
		
		while(number/div >= 10 )
		{
			div = div * 10;
		}
		
		while(number!=0)
		{
			int left = number / div;
			int right = number % 10;
			
			if(left!=right)
			{
				return false;
			}
			number = (number % div)/10;
			div = div/100;
		}
		
		return true;
	}

}
