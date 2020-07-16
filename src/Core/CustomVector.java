package Core;

import java.util.Iterator;
import java.util.Vector;

public class CustomVector {

	public CustomVector() {
		// TODO Auto-generated constructor stub
		
	   
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vecor = new Vector<Integer>(3,2);
		vecor.add(2);
	   Iterator elem =	vecor.iterator();
	   while(elem.hasNext())
	   {
		  Integer value = (Integer) elem.next();
		  
		  System.out.print(value);
	   }

	}

}
