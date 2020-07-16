 package String;

public class PermuatationPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Checks if a string evaluates to a palindrome
	public boolean IsPermutation(String input)
	{
		int[] charMap = new int[Character.getNumericValue('a') - Character.getNumericValue('z')+1];
		int oddCount = 0;
		for(int i=0;i<input.length();i++)
		{
			Character c  = input.charAt(i);
			int numbermap = Character.getNumericValue(c);
			charMap[numbermap] ++;
			if(charMap[numbermap] % 2 == 1)
			{
				oddCount++;
			} else
			{
				oddCount--;
			}
	
		}
		return oddCount <=1;
	
	}
}
