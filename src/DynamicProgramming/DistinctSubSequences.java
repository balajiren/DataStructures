package DynamicProgramming;

public class DistinctSubSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int FindDistinctSubSequences(String s, String t)
	{
		int[][] table = new int[s.length()+1][t.length()+1];
		for(int i=0;i<s.length();i++)
		{
			for(int st=0;st<s.length();st++)
			{
				table[st][0] = 1;
			}
			for(int j=1;j<t.length();j++)
			{
				
				if(s.charAt(i-1) == t.charAt(j-1))
				{
					table[i][j] += table[i-1][j]+table[i-1][j-1];
				} else
				{
					table[i][j] +=table[i-1][j];
				}
			}
			
		}
		
		return table[s.length()][t.length()];
	}

}
