package BitManipulation;

public class MxBinaryGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getGap(1001));

	}
	
	public static int getGap(int N) {
		int max = 0;
		int count = -1;
		int r = 0;
	 
		while (N > 0) {
			// get right most bit & shift right
			r = N & 1;
			N = N >> 1;
	 
			if (0 == r && count >= 0) {
				count++;
			}
	 
			if (1 == r) {
				max = count > max ? count : max;
				count = 0;
			}
		}
	 
		return max;
	}

}
