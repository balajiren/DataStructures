package Tree;

import java.util.LinkedList;
import java.util.List;

import Graph.*;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public enum State{
		
		UnVisited,
		Visiting,
		Visited
	}
	
	public boolean search(Graph g, GraphNode<Integer> start, GraphNode<Integer>  end)
	{
		
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		
		if(start == end)
		{
			return true;
		}

		for(GraphNode g1 : start.getNodes())
		{
			g1.state = State.UnVisited;
		}
		start.state = State.Visiting;
		queue.add(start);
		Node u;

	    while(!queue.isEmpty())
	    {
	    	GraphNode<Integer>  node = queue.removeFirst();
	    	node.state = State.Visited;
	    	for(GraphNode g2 : node.getNodes())
	    	{
	    		if(g2.state !=State.Visited) 
	    		{
	    			if(end == g2) {
	    				return true;
	    			}
	    			else
	    			{
	    			queue.offer(g2);
	    			}
	    		}
	    		g2.state =State.Visited;

	    	}
			
	    	
	    }
		
		return false;
	}

}
