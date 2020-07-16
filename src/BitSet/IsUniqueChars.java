package BitSet;

public class IsUniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean IsUnique(String s)
	{
		char[] arr=s.toCharArray();
		
		int checker =0;
		
		for(int i=0;i<arr.length;i++)
		{
			int val = s.charAt(arr[i]) - 'a';
			if((checker & (1<<val)) > 0)
			{
				return false;
			}
 			checker|=(1<<val);
			
		}
		return true;
	}

}
