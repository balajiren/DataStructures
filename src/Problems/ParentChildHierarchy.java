package Problems;

import java.util.List;
import java.util.*;


public class ParentChildHierarchy {


public class Group
{
	
	public String name;
	public List<Group> parent;
	public List<Group> members;
	public List<String> users;
	
	
	public Group(String groupName)
	{
		name = groupName;
	
	}
	

	
}


public HashMap<String,Group> FindMemberShip(HashMap<String, HashSet<String>> groups)
{
	HashMap<String,Group> visitedGroups = new HashMap<String,Group>();
	Iterator listGroups = groups.keySet().iterator();
	
	while(listGroups.hasNext())
	{
		 String parentGroup = listGroups.next().toString();	
		 
		
		
		
		
	}
	
	
	return visitedGroups;
}

public static void main(String args[])
{

	HashMap<String, HashSet<String>> groups = new HashMap<String, HashSet<String>>();

	HashSet<String> temp1 = new HashSet<String>();
	temp1.add("U1");
	temp1.add("G1");
	groups.put("G4", temp1);
	
	HashSet<String> temp2 = new HashSet<String>();
	temp2.add("G2");
	temp2.add("G3");
	groups.put("G1", temp2);
	
	HashSet<String> temp3 = new HashSet<String>();
	temp3.add("G3");
	temp3.add("G5");
	groups.put("G3", temp3);
	
	HashSet<String> temp4 = new HashSet<String>();
	temp4.add("U2");
	temp4.add("G4");
	groups.put("G2", temp4);
	
	HashSet<String> temp5 = new HashSet<String>();
	temp5.add("U2");
	temp5.add("G6");
	groups.put("G5", temp5);
			
	HashSet<String> temp6 = new HashSet<String>();
	temp6.add("U3");
	groups.put("G6", temp6);
	
	
}


}
