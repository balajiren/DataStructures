package Graph;
import java.util.*;

public class TopologicalSort {

	
	private int V;   // No. of vertices  
	  
    // Adjacency List as ArrayList of ArrayList's 
    private ArrayList<ArrayList<Integer>> adj;  
    
    //Constructor  
    TopologicalSort(int v)  
    {  
        V = v;  
        adj = new ArrayList<ArrayList<Integer>>(v);  
        for (int i=0; i<v; ++i)  
            adj.add(new ArrayList<Integer>());  
    }  
    
    // Function to add an edge into the graph  
    void addEdge(int v,int w) { adj.get(v).add(w); }  
    
    void topologicalSortUtil(int v, Stack<Integer> st,boolean visited[]) {
    	
    	visited[v] = true;
    	Iterator<Integer> edges = adj.get(v).iterator();
    	while(edges.hasNext()) {
    		int i = edges.next();
    		if(!visited[i]) {
    			topologicalSortUtil(i,st,visited);
    		}
    		
    	}
    	st.push(new Integer(v));
    	
    }
    void topologicalSort()  {
    	
    	Stack<Integer> st = new Stack<Integer>();
        boolean visited[] = new boolean[V];
    	for(int i=0;i<V;i++) {
    		visited[i]= false;
    	}
    	for(int i=0;i<V;i++) {
    		if(!visited[i]) {
    			topologicalSortUtil(i,st,visited);
    		}
    		
    		
    	}
    	while(!st.isEmpty()){
    		System.out.print(st.pop() + " ");  
    	}
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Create a graph given in the above diagram  
		TopologicalSort g = new TopologicalSort(6);  
        g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);  
    
        System.out.println("Following is a Topological " +  
                           "sort of the given graph");  
        g.topologicalSort();  

	}

}
