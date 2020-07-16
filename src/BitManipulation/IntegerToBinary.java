package BitManipulation;

import java.util.Arrays;

//References : http://www.roseindia.net/java/master-java/bitwise-bitshift-operators.shtml

public class IntegerToBinary {

	  public static void printBinaryFormat(int number){
	        int binary[] = new int[25];
	        int index = 0;
	        while(number > 0){
	            binary[index++] = number%2;
	            number = number/2;
	        }
	        //System.out.println(Arrays.toString(binary));
	        for(int i = index-1;i >= 0;i--){
	            System.out.print(binary[i]);
	        }
	    }
	  
	  
	  public static void CountNumberOfBits(int n)
	  {
		  
		 int count =0 ;
		 while(n > 0)
		 {
			 n &= n-1;
			 count++;
			 
			 
		 }
		 System.out.println(count);
		  
	  }
	     
	    public static void main(String a[]){
	        printBinaryFormat(8);
	        //CountNumberOfBits(8);
	    }

}
