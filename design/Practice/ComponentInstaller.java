package Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Core.Edge;
import Core.Graph;
import Core.Vertex;
import Helpers.Utils;


public class ComponentInstaller implements IComponentInstaller {

	static HashSet<Vertex> edgeMap = new HashSet<Vertex>();
	public static Graph dependencyGraph = null;
	public Set<String> InstalledComponents;
	
	public ComponentInstaller() {
		// TODO Auto-generated constructor stub
		Initialize();
		InstalledComponents= new HashSet<String>();
	}

	
	public static void Initialize()
	{
		
		Component c1 = new Component("C1");
		Component c2 = new Component("C2");
		Component c3 = new Component("C3");
		Component c4 = new Component("C4");
		ArrayList<Vertex> arrVertices = new ArrayList<Vertex>();
		Vertex v1 = new Component(c1.getLabel());
		arrVertices.add(v1);
		Vertex v2 = new Component(c2.getLabel());
		arrVertices.add(v2);
		Vertex v3 = new Component(c3.getLabel());
		arrVertices.add(v3);
		Vertex v4 = new Component(c4.getLabel());
		arrVertices.add(v4);
		
	
		Graph g1 = new Graph(arrVertices);
		g1.addEdge(v2, v1);
		//g1.addEdge(v3, v2);
		//g1.addEdge(v3, v4);
		dependencyGraph = g1;
		g1.addEdge(v2, v4);

	}
	
	//Installs the component
	public boolean InstallComponent(Component c)
	{
		InstalledComponents.add(c.getLabel());
	    Vertex v = dependencyGraph.getVertex(c.getLabel());
	    HashSet<Vertex> dependencies = GetDependencies(v);
	    Iterator dependencyListIter = dependencies.iterator();
	    while(dependencyListIter.hasNext())
	    {
	    	Vertex inv = (Vertex) dependencyListIter.next();
	    	if(!InstalledComponents.contains(inv.getLabel()))
	    	{
	    		Utils.PrintMessage("Missing dependencies"+inv.getLabel());
	    		return false;
	    	}
	    	
	    }
	    Utils.PrintMessage("Component successfully installed"+c.getLabel());
	    return true;
	}
	
	
	public boolean RemoveComponent(Component c)
	{
		InstalledComponents.add(c.getLabel());
	    Vertex v = dependencyGraph.getVertex(c.getLabel());
	    HashSet<Vertex> dependencies = GetDependencies(v);
	    Iterator dependencyListIter = dependencies.iterator();
	    while(dependencyListIter.hasNext())
	    {
	    	Vertex inv = (Vertex) dependencyListIter.next();
	    	if(InstalledComponents.contains(inv.getLabel()))
	    	{
	    		Utils.PrintMessage("Cannot remove "+ c.getLabel()+"Existing dependencies"+inv.getLabel());
	    		return false;
	    	}
	    	
	    }
	    Utils.PrintMessage("Component successfully removed"+c.getLabel());
	    return true;
	}
	
	public HashSet<Vertex> GetDependencies(Vertex v1)
	{
		
		edgeMap.add(v1);
		ArrayList<Edge> edges = v1.getNeighbors();
		for(Edge e : edges)
		{
			if(!edgeMap.contains(e.getOne()))
			{
				edgeMap.add(e.getOne());
				GetDependencies(e.getOne());
				
			}
		
			if(!edgeMap.contains(e.getTwo()))
			{
				edgeMap.add(e.getTwo());
				GetDependencies(e.getTwo());
				
			}
		
		}
	
	
	return edgeMap;
	}

}
