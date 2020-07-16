package KeyValueStore;

import java.util.*;

public class NodeListHelper {
	
	Dictionary<String,Node> _nodes = new Hashtable<String,Node>();
	public Node GetHashNode(String IpRange) throws Exception
	{
		HashFunctionHelper helper = new HashFunctionHelper();
		String hashedNodeKey = helper.GethashString(IpRange);
		return GetNode(hashedNodeKey);
		

	}
	
	public void AddNode(String key)
	{
		
		Node n = new Node(key,"", "");
		this._nodes.put(key,n);
	}
	
	public void RemoveNode(String name)
	{
		this._nodes.remove(name);
	}
	
	private  Node GetNode(String key)
	{
		 return this._nodes.get(key);
	}

}
