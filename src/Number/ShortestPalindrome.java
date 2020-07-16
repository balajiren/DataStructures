package Number;

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int result = ClosestPalindrome(1234);
         System.out.println(result);
	}
	
	private static boolean  IsPalindrome(String  nstr) {
		
		char[] n = nstr.toCharArray();
		for(int i=0;i<n.length/2;i++) {
			if(n[i]!=n[n.length-1-i]) {
				return false;
			}
		}
		return true;
	}
	
	private static int ClosestPalindrome(int n) {
		int lower = n-1;
		while(!IsPalindrome(String.valueOf(Math.abs(lower) ))) {
			lower--;
		}
		int greater = n+1;
		while(!IsPalindrome( String.valueOf(Math.abs(greater)))){
			greater++;
		}
		return Math.min(n-lower, n-greater);
		
	}

}
