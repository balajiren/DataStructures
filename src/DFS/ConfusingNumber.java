package DFS;

public class ConfusingNumber {

	public static int[] valid = {0, 1, 6, 8, 9};
	public static int[] reverse = {0, 1, 2, 3, 4, 5, 9, 7, 8, 6};
	static int res = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		confusingNumberII(20);

	}
	
	public static int confusingNumberII(int N) {
		dfs(0, N);
		return res;
	}
	
	
	
	
	public static void dfs(int num, int N) {
		
		if(IsValid(num)) {
			res++;
		}
		for(int i=0;i<valid.length;i++) {
			
			if(i==0 && num == 0) continue;
			int digit = valid[i];
			if((Integer.MAX_VALUE - digit) / 10 < num || num*10+digit > N) {
				continue;
			}
			dfs(num*10+digit,N);
			
		}
		
		
	}
	
	public static boolean IsValid(int num) {
		
		long rev = 0;
		int copy=num;
		//reverse the number
		while(num!=0) {
			int digit = num%10;
			rev = rev * 10 + reverse[digit];
			num/=10;
		}
	
		return num!=copy;
		
	}

}
