package Graph;

import java.util.ArrayList;

public class GraphNode1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int numberOfEdges = 0;
	GraphNode1 next;
	int val = 0;
	GraphNode1[] neighbours;
	boolean visited;
	
	public GraphNode1(int n)
	{
		val = n;
		
	}
	public GraphNode1[]  getNeighbours()
	{
		GraphNode1[] n = null;
		ArrayList<GraphNode1> neighbours = new ArrayList<GraphNode1>();
		while(next != null)
		{
		
			neighbours.add(next);
			next = this.next;
		}
		return (GraphNode1[]) neighbours.toArray();
	}
	

}
