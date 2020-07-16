package BackTracking;
import java.util.*;

public class NQueensProblem {

	static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		result = new int[n];
		PlaceQueens(0,6);

	}
	
	
	public static void PlaceQueens(int startPos, int size)
	{
		for(int i=0;i<size;i++)
		{
			if(CanPlaceQueens(startPos,i))
			{
				result[startPos] = i;
				if(startPos == size -1)
				{
					System.out.println("Order of " + size + " queens"
							+ Arrays.toString(result));
				}
				 PlaceQueens(startPos+1, size);
			}
		}
		
	}
	public static boolean CanPlaceQueens(int currentPos, int newPos)
	{
		for(int i=0;i<currentPos;i++)
		{
			
			if(result[i] == newPos)
			{
				return false;
			}
			if(Math.abs(i-currentPos)== Math.abs(result[i] - newPos))
			{
				return false;
			}
	
		}
		
		
		return true;
	}

}
