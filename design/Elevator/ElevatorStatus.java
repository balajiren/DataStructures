package Elevator;



public enum ElevatorStatus {
	  ELEVATOR_OCCUPIED,  // Elevator is occupied by users inside who are request floors
	  ELEVATOR_EMPTY,      // Elevator is empty and can be used to request a pickup
	  ELEVATOR_UP,      // Elevator is going up
	  ELEVATOR_DOWN,    // Elevator is going down
	  ELEVATOR_HOLD     // Elevator is being held
	}
