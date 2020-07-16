package Graph;

import java.util.*;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public GraphNode<Integer> CloneGraph(GraphNode<Integer> node)
	{
		GraphNode<Integer> result = null; 
		if(node.next == null)
		{
			result = node;
		}
		Queue<GraphNode> que = new LinkedList<GraphNode>();
		Map<GraphNode,GraphNode> nodemap = new HashMap<GraphNode,GraphNode>();
		que.offer(node);
		nodemap.put(node, result);
		List<GraphNode> neighbours = node.getNodes();
		while(que.size() > 0)
		{
			GraphNode curr = que.poll();
			for(GraphNode  n : neighbours)
			{
				que.offer(n);
				if(!nodemap.containsKey(n))
				{
					GraphNode<Integer> copy = new GraphNode<Integer>((Integer) n.nodeId);
					nodemap.put(n, copy);
					//nodemap.get(curr).no
				}
				
			}
			
		}
		
		return node;
				
	}

}
