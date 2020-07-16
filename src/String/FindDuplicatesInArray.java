package String;

public class FindDuplicatesInArray {

	public FindDuplicatesInArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[]{1,2,4,1,3,1,2,4};
		FindDuplicates(input);

	}
	
	
	public static void FindDuplicates(int[] input)
	{
		StringBuilder builder = new StringBuilder();
		int flags[] = new int[input.length];
		for(int i : flags)
		{
			flags[i] = 0;
			
		}
		for(int i : input)
		{
			if(flags[i] == -1)
			{
				//flags[i] = 1;
				builder.append(i+"-->"+"\n");
			}
			else
			{
				flags[i]  = -1;
			}
			
		}
		
		System.out.print(builder.toString());
		
	}

}
