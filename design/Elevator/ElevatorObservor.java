package Elevator;
import java.util.*;

public class ElevatorObservor 
{
	
   List<Elevator> el = new ArrayList<Elevator>();

   ElevatorObservor()
   {
	   el = ElevatorController.elevators;

	   
   }

	public void SetElevatorStatus(int elevatorIndex, int currentFloor)
	{
		el.get(elevatorIndex).currentFloor = currentFloor;
		
	}
	
	public int GetElevatorFloor(int index)
	{
		return el.get(index).currentFloor;
	}


}
