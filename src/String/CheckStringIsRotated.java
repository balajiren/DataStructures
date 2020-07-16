package String;

public class CheckStringIsRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//'Jaain' and 'ainJ'
		// niaaj
		boolean status = IsStringRotated("ainJ","Jaain");
		System.out.println(status);
		
	}
	
	public static boolean IsStringRotated(String s1, String s2)
	{
	  String temp = s1 + s1;
	  if(temp.contains(s2))
	  {
		  return true;
	  }
	  return false;
		
	}
	

}
