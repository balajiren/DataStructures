package Graph;

public class PartyProblem {

	public PartyProblem() {
		// TODO Auto-generated constructor stub
	}
	
	public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
         
        int left = 0;
        int right = n - 1;
         
        // Step 1: Find the potential candidate
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }
         
        // Step 2: Validate the candidate
        int candidate = right;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }
         
        return candidate;
    }

	private static boolean knows(int left, int right)
	{
		return false;
	}

}
