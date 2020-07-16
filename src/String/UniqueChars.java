package String;

public class UniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stubm.
		String result = GetDuplicateChars("balaji");
		System.out.print(result);

	}
	
	public  static String GetDuplicateChars(String s)
	{
		
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean[] char_set = new boolean[256];
		
		for(char c : chars)
		{
			if(char_set[c])
			{ 
				sb.append(String.valueOf(c));
				
			}
			
			char_set[c] = true;
		}
		
		return sb.toString();
		
		
	}

}
