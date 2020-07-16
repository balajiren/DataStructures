package Elevator;

public abstract class SchedulingStratergy implements Comparable<Elevator>{

	int requestedFloor;
	ElevatorRequest req;
	
	SchedulingStratergy(ElevatorRequest _req)
	{
		requestedFloor = req.currentFloor;
		this.req = _req;
	}
	
	
	public int compareTo(Elevator o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
