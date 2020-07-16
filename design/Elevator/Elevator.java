package Elevator;

public class Elevator {
	
	public int currentFloor;
	
	public int GetCurrentFloor()
	{
		return currentFloor;
	}
	public void MoveUp()
	{
		
	}
	public void MoveDown()
	{
		
	}
	
	public void OpenDoor()
	{
		
	}
	public void CloseDoor()
	{
		
		
	}
	public void NotifyObservor(int elevatorIndex, int currentFloor)
	{
		ElevatorObservor obs = new ElevatorObservor();
		obs.SetElevatorStatus(elevatorIndex, currentFloor);
	}

}
