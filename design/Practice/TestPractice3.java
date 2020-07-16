package Practice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Core.*;
import Helpers.Utils;

//The question was about building an installer that had components dependent on one another. 
//You cant install a component unless its dependents are installed.
//Likewise you cant remove a component, if there is another component dependent on it.
//The problem wasn't hard but certainly it was challenging to produce clean code in the given time

public class TestPractice3 {

	static Graph g1 = null;
	static HashSet<Vertex> edgeMap = new HashSet<Vertex>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		ComponentInstaller installer = new ComponentInstaller();
		installer.InstallComponent(new Component("C2"));
		boolean  status = installer.InstallComponent(new Component("C4"));
	    System.out.print(status);
	
		/*GetAllConnectedEdges(g1.getVertex("C3"));
		Iterator<Vertex> iter = edgeMap.iterator();
		StringBuffer buffer = new StringBuffer();
		buffer.append("Connected components : ");
		while(iter.hasNext())
		{
			buffer.append(iter.next());
		}
		Utils.PrintMessage(buffer.toString()); */
		
	}

	
	
	public static Set<Edge> GetConnectedEdges(Vertex v1)
	{
		return g1.getEdges();
	}
	
	public static HashSet<Vertex> GetAllConnectedEdges(Vertex v1)
	{
        	edgeMap.add(v1);
			ArrayList<Edge> edges = v1.getNeighbors();
			for(Edge e : edges)
			{
				if(!edgeMap.contains(e.getOne()))
				{
					edgeMap.add(e.getOne());
					GetAllConnectedEdges(e.getOne());
					
				}
			
				if(!edgeMap.contains(e.getTwo()))
				{
					edgeMap.add(e.getTwo());
					GetAllConnectedEdges(e.getTwo());
					
				}
			
			}
		
		
		return edgeMap;
	}
	
	
	public static void InstallComponent(Component c)
	{
		
		GetAllConnectedEdges(new Vertex(c.getLabel()));
	
		
	}
	

}
