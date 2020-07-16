package Recursion;

public class MakeChangeForDenomination {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(String.valueOf(makechange(100,25)));

	}
	
	
	public static int makechange(int amount, int denomination)
	{
		int denom_length = 2;
		int[][] map = new int[amount+1][2];
		return lmakeChange(amount,denomination,0,map);
	}
	
	public static int lmakeChange(int amount, int denomination,int index, int[][] map)
	{
		if(map[amount][index] > 0)
		{
			return map[amount][index];
		}
		int next_denomation = 0;
		switch(denomination)
		{
		  
		case 25:
			next_denomation = 10;
			break;
		case 10:
			next_denomation = 5;
			break;
		case 5:
			next_denomation = 1;
			break;
		case 1:
			return 1;

		}
		
		int ways =0;
		for(int i=0;i * denomination <= amount;i++)
		{
			ways+=lmakeChange(amount- i* denomination,next_denomation,index+1, map);
		}
		map[amount][index] = ways;
		return ways;
	}

}
