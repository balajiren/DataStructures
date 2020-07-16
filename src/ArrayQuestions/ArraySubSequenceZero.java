package ArrayQuestions;
import java.util.*;

public class ArraySubSequenceZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean res = FindSubSequence(new int[]{2,3,1,-1,2},0);
		System.out.println(res);

	}
	
	
	public static boolean FindSubSequence(int[] input, int target)
	{
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> numSet = new HashMap<Integer,Integer>();
		int sum = 0;
		for(int i : input)
		{
			sum+= i;
			if(numSet.containsValue(sum))
			{
				return true;
			}
			numSet.put(i,sum);
		}
	
		return false;
		
	}
}
