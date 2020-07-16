package Elevator;

public class ShortestSeekFirst extends SchedulingStratergy {
	
	
	ShortestSeekFirst(ElevatorRequest req)
	{
		super(req);
	}

	@Override
	public int compareTo(Elevator o) {
		// TODO Auto-generated method stub
		return o.GetCurrentFloor() - super.requestedFloor;
	}
	


}
