






package DynamicProgramming;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String strA =  "AABCDEBAZ";
		int result =FindPalindrome(strA);
		System.out.println("Length of Longest Palindrome in '" + strA + "' is- " + result);
	}
	
	public static void printMatrix(int [][] LP){
		for(int i=0;i<LP.length;i++){
			for(int j=0;j<LP.length;j++){
				System.out.print("  " + LP[i][j]);
			}	
			System.out.println("");
		}
	}
	public static int FindPalindrome(String input)
	{
		
		char[] chars = input.toCharArray();
		int[][] solution = new int[chars.length][chars.length];
		
		for(int i=0;i<chars.length;i++)
		{
			solution[i][i]=1;
		}
		
		for(int sublen=2;sublen <= chars.length;sublen++)
		{
			
			for(int i=0;i<=solution.length-sublen;i++)
			{
				int j = i+sublen - 1;
				if(chars[i] == chars[j] && sublen == 2)
				{
					solution[i][j] = 2;
				}
				else if(chars[i] == chars[j])
				{
					solution[i][j]  = 2 + solution[i+1][j-1];
				}
				else
				{
					solution[i][j] = Math.max(solution[i+1][j],solution[i][j-1]);
				}
			}
			
			
		}
		
		printMatrix(solution);
		return solution[0][solution.length-1];
		
	}

}
