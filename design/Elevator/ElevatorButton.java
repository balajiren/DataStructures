package Elevator;

public class ElevatorButton {

    ElevatorRequests requests;
	public void placeRequest()
	{
		requests.addRequest(new ElevatorRequest(1, true));
		
	}
}
