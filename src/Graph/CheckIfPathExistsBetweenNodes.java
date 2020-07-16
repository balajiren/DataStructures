package Graph;
import java.util.HashMap;
import java.util.LinkedList;

import Graph.*;

public class CheckIfPathExistsBetweenNodes {

	
	public enum VisitedStatus
	{
		Visited,
	    NotVisited
		
	}
	
	public static boolean CheckIfpathExists(Graph input, Vertex source, Vertex destination)
	{
		LinkedList<Vertex> nodes = new LinkedList<Vertex>();
		
		HashMap<String, Vertex> vertexMap =	input.GetAllVertices();

        for(Vertex v : vertexMap.values())
        {
        	v.IsVisited = false;
        }
        //Vertex current = source;
        //Vertex next = current.getNeighbors();
        //while(current.)
		return false;
	}
	
}
