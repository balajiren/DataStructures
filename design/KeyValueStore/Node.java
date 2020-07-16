package KeyValueStore;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int id;
	String name;
	String next;
	String prev;
	Entry entry;

	Node(String _name, String _next, String _prev)
	{
		this.name = _name;
		this.next =  _next;
		this.prev = _prev;
		entry = new Entry();
		
	}
	

	
}
