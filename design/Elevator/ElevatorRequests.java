package Elevator;
import java.util.*;

public class ElevatorRequests {
	
	List<ElevatorRequest> requests;
	
	ElevatorRequests()
	{
		requests = new ArrayList<ElevatorRequest>();
		
	}
	
	public void addRequest(ElevatorRequest request)
	{
		requests.add(request);
		
	}
	
	public void removeRequest(ElevatorRequest request)
	{
		requests.remove(request);
		
	}
	
	public ElevatorRequest GetNextRequestToProcess()
	{
		return null;
		
	}
	

}
