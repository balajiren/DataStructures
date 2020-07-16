package Recursion;

public class WellOrderedPasswords {

	public WellOrderedPasswords() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printNumberSequence_comb(0,0,7);

		int n =4;
		//sprintAllAddingSubSets(n,"");
	}

	public static void printNumberSequence_comb(int number, int index, int iter) {

		if(iter == 0) {
			System.out.println(number);
			return;
		}

		for(int i=index+1;i<10;i++) {

			printNumberSequence_comb(number*10+i,i,iter-1);
		}



	}
	
	
	public static void PrintNumberSequence(int number, int y, int iter)
	{
		int i;
		if(iter == 0)
		{
			System.out.println(number);
			return;
		}
		
		for(i=y+1;i<10;i++)
		{
			PrintNumberSequence(number*10+i,i,iter-1);
		}
		
		
		
	}

	public static void printAllAddingSubSets(int n, String x){
		if(n==0){
			System.out.println(x);
			return;
		}else{
			for(int i=1;i<=n;i++){
				x = x + i;				
				printAllAddingSubSets(n-i,x);
				x = x.substring(0,x.length()-1);
			}
		}
	}

}
