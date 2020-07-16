package BitManipulation;

public class BitConvertion {

	
	  public static void main(String a[]){
		  
		  
	  
	  }
	  
	  public int NumberOfBitsToConvert(int i1, int i2)
	  {
		  int count = 0;
		  
		  for(int 	c = i1 ^ i2; c !=0; c = c >> 1)
		  {
			  count+=c & 1;
		  }
		  
		  return count;
	  }
}
