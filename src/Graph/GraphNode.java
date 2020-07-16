package Graph;

import java.util.ArrayList;
import java.util.List;

import Tree.RouteBetweenNodes.State;

public class GraphNode<T> {

	        T nodeId;
	        GraphNode next;
	        int parentDist;
	        List<GraphNode> connectedNodes;
	        public State state;
	        public enum GraphState{
	    		
	    		UnVisiting,
	    		Visiting,
	    		Visited
	    	}
	 
	        GraphNode(T id)
	        {
	            nodeId = id;
	            next = null;
	        }
	 
	        GraphNode(T id, int dist)
	        {
	            nodeId = id;
	            next = null;
	            parentDist = dist;
	        }
	        
	        public List<GraphNode> getNodes()
	        {
	        	connectedNodes = new ArrayList<GraphNode>();
	        	return connectedNodes;
	        }
	    
}
