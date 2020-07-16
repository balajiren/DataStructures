package Practice;
import java.io.IOException;
import java.util.*;

import Core.Edge;
import Core.Graph;
import Core.Vertex;
import Helpers.IReader;
public class PracticeTest1 {

	Graph graph = null;
	Vertex sourcePerson = null;
	Vertex friend1 = null;
	Vertex  friend2 = null;
	HashSet<Vertex> friends = new HashSet<Vertex>();
	IReader _reader = null;
	
	public PracticeTest1()
	{
		graph = new Graph();
		sourcePerson = new Vertex("Balaji");
		graph.addVertex(sourcePerson, false);
		friend1 = new Vertex("swathi");
		graph.addVertex(friend1, false);
		friend2= new Vertex("zareen");
		graph.addVertex(friend2, false);

	}
	
	public PracticeTest1(IReader reader)
	{
		_reader = reader;
	}
	public String ReadStringFromFile(String path) throws IOException
	{
		return _reader.ReadFile(path);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeTest1 prac = new PracticeTest1();
		prac.MakeFriends();
		prac.GetDirectFriends("Balaji");
		//prac.RemoveFriends("Balaji", "swathi");
		prac.GetIndirectFriends("Balaji");
		

	}
	
	
	public boolean MakeFriends()
	{

		graph.addEdge(sourcePerson, friend1);
		//graph.addEdge(sourcePerson, friend2);
	   // graph.addEdge(friend1,friend2);
		for(Edge e : graph.getEdges())
		{
			
			System.out.print(e);
		}
		return true;
		
	}
	
	public boolean RemoveFriends(String source, String friend)
	{
		Vertex v1 = graph.getVertex(source);
		ArrayList<Edge>  edges = v1.getNeighbors();
		for(Edge e : edges)
		{
			if(e.getTwo().getLabel() == friend)
			{
				graph.removeEdge(e);
			}
		}
		return true;
	}
	
	public boolean GetDirectFriends(String source)
	{
		Vertex v1 = graph.getVertex(source);
		ArrayList<Edge>  edges = v1.getNeighbors();
		StringBuffer buffer  = new StringBuffer();
		
		for(Edge e : edges)
		{
			buffer.append(e.getTwo().getLabel()+"\n");
			
		}
		if(buffer.length() > 0)
		{
			System.out.print("Direct Friends \n"+buffer.toString());
		}
		return true;
	}
	
	private String GetRecursiveFriends(String source, ArrayList<Edge> edges)
	{
	  
		for(Edge e : edges)
		{
			Vertex toFriend = e.getTwo();
			//Vertex fromFriend = e.getOne();
			if(!friends.contains(toFriend))
			{
				friends.add(toFriend);
				GetRecursiveFriends(toFriend.getLabel(),toFriend.getNeighbors());

			}
      
		}
		StringBuffer buffer = new StringBuffer();
		for(Vertex v: friends)
		{
			buffer.append(v.getLabel());
			
		}
		return buffer.toString();
		
	}
	
	public boolean GetIndirectFriends(String source)
	{
		
		Vertex v1 = graph.getVertex(source);
		ArrayList<Edge>  edges = v1.getNeighbors();
		System.out.print("In Direct Friends \n"+GetRecursiveFriends(source,edges));
		return true;

	}

}
