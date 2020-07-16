package Practice;

import java.util.ArrayList;

import Core.Edge;
import Core.Vertex;

public class Component extends Vertex implements IComponent{

	public Component(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	 /**
     * This method adds an Edge to the incidence neighborhood of this graph iff
     * the edge is not already present. 
     * 
     * @param edge The edge to add
     */
    public void addNeighbor(Edge edge){
    	super.addNeighbor(edge);
    }
    
    
    /**
     * 
     * @param other The edge for which to search
     * @return true iff other is contained in this.neighborhood
     */
    public boolean containsNeighbor(Edge other){
    	return super.containsNeighbor(other);
    }
    
   
    /**
     * 
     * @return ArrayList<Edge> A copy of this.neighborhood. Modifying the returned
     * ArrayList will not affect the neighborhood of this Vertex
     */
    public ArrayList<Edge> getNeighbors(){
        return super.getNeighbors();
    }

	@Override
	public Component BuildComponent(String name) {
		// TODO Auto-generated method stub
		Component comp = new Component(name);
		return comp;
	}

}
