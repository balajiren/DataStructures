package ArrayQuestions;

public class MajorityVoteAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int FindMajorityElement(int[] nums) {
		
		int result = 0;
		int count = 0;
		for(int i: nums) {	
			if(count == 0) {
				result = i;
				count = 1;
			} else
			{
				if(result == i) {
					count++;
				} else
				{
					count--;
				}
			}
		}
		return result;
		
	}

}
