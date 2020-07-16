package Graph;
import java.util.*;
public class DFSGraph {

	private static LinkedList<Integer> adj[];
	private static int V;
	DFSGraph(int v)
	{ 
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
		
	}
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSGraph g = new DFSGraph(4);
		    g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(0, 3);
	        g.addEdge(2, 0);
	        g.addEdge(2, 1);
	        g.addEdge(1, 3);
	        g.DFS(2,3);
	    

	}
	
	// Prints all paths from
    // 's' to 'd'
    public static void printAllPaths(int s, int d) 
    {
        boolean[] isVisited = new boolean[100];
        ArrayList<Integer> pathList = new ArrayList<>();
         
        //add source to path[]
        pathList.add(s);
         
        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }
 
    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private static void printAllPathsUtil(Integer u, Integer d,
                                    boolean[] isVisited,
                            List<Integer> localPathList) {
         
        // Mark the current node
        isVisited[u] = true;
         
        if (u.equals(d)) 
        {
            System.out.println(localPathList);
        }
         
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adj[u]) 
        {
            if (!isVisited[i])
            {
                // store current node 
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                 
                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }
         
        // Mark the current node
        isVisited[u] = false;
    }
	

	private static void DFS(int source, int destination)
	{
		boolean[] visited = new boolean[V];
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(source);
		printAllPaths(2,3);
		

		
		
	}

}
