package LinkedList;
import java.util.*;

import Common.Utils;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> lst = new LinkedList<String>();
		lst.addFirst("Balaji");
		lst.add("swathi");
		
		
		int count = 0;
		ListIterator<String> listIterator = lst.listIterator();
		while(listIterator.hasNext())
		{
	       
			Utils.PrintMessage(listIterator.next());
	
		}

	}

}
