package TopologicalSort;
import java.util.*;

//visited time <= low time of vertex
//tarjans algorithm
public class CriticalConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Integer>[] graph;
	boolean[] visited;

	 // It tracks visited counter (depth). Every DFS increments this number. 
	// Once assigned, Its never changed.
	int[] visitedTime; 

	// It tracks lower visited Time. (Hold on to it. You will understand later).
	// One think to note : at start, it will be same as visitedTime. Later it can change.
	int[] lowTime;

	int time;
	        
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	    List<List<Integer>> critical = new ArrayList<>();
	    graph = new ArrayList[n];
	    time = 0;
	    lowTime = new int[n];
	    visitedTime = new int[n];
	    visited = new boolean[n];
	    
	    buildGraph(n, connections);
	    dfs(critical, 0, -1);
	    return critical;
	}

	private void buildGraph(int n, List<List<Integer>> connections) {
	    for(int i = 0 ; i < n ; i++)
	    {
	        graph[i] = new ArrayList<Integer>();
	    }
	    
	    for(List<Integer> item : connections)
	    {
	        int a = item.get(0);
	        int b = item.get(1);
	        
	        graph[a].add(b);
	        graph[b].add(a);
	    }
	}

	private void dfs(List<List<Integer>> critical, int currentNode, int parentNode) {
	   // Set current node as visited and assign Time starting from 0.
	    visited[currentNode] = true;
	    visitedTime[currentNode] = lowTime[currentNode] = time++;
	    
	    List<Integer> neighbors = graph[currentNode];
	    for(Integer neighbor : neighbors)
	    {
	        // Three options. Neighbors could be of 3 types.
	        // 1) Parent
	        // 2) Not Visited
	        // 3) Visited.
	        
	        // If parent, ignore, 
	        // If not visited, apply another dfs on neighor
	        // If visited , pick some important information from neigbor...
	        // (think about what it is) ...
	        // One thing is obvious, vistedTime of previously visited nodes will be lower than current's.
	        // Perhaps, you can copy it into current's lowTime. 
	        
	        if(neighbor == parentNode)
	            continue;
	        
			// Jump to else condition first then come back here.
	        if(!visited[neighbor])
	        {
	            dfs(critical, neighbor, currentNode);
	    // after we finish DFS, there is a possiblity neighor's lowerTime less than current. 
	            lowTime[currentNode] = Math.min(lowTime[currentNode], lowTime[neighbor]);
	            
	    // we know vistedTime[currentNode] < visitedTime[neighbor] (always) 
	    // b/c neighour are accessed after current)
	    // ----        
	    // But neighbor's lowerTime could be less than current, which means they had touch any cycle node. (covered by above line of code)
	    // Or It's also possible that
	    // neighbor's lowerTime could be higher than current, which means they didn't touch any previously visited node or had a cycle.
	    // If later is true, there is bridge, if we delete this edge, graph will be broken into two components. So, its critical.
	            if(lowTime[neighbor] > visitedTime[currentNode])
	            {
	                ArrayList<Integer> both = new ArrayList<>(); both.add(currentNode); both.add(neighbor);
	                critical.add(both);
	            }
	        }
	        else
	        {
	            // whenever you look at already visited node, just pick its visitedTime/lowTime if it's lower.
	            // it will be lower if It was visited earlier and probably making a cycle.
	            lowTime[currentNode] = Math.min(lowTime[currentNode], lowTime[neighbor]);
	        }
	    }
	}

}
