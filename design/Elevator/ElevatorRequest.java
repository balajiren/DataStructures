package Elevator;

public class ElevatorRequest {

    int currentFloor;
    boolean IsUp;
    ElevatorRequest(int floorId, boolean isUp)
    {
    	this.currentFloor = floorId;
    	this.IsUp = isUp;
    	
    }
}
