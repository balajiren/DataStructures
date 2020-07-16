package ParkingLot;

public class Level {

	private int floor;
	private ParkingSpot[] spots;
	private int _availableSpots = 0;
	
	public int availableSpots()
	{
		return _availableSpots;
	}
	
	public int FindAvailableSpots(Vehicle vehicle)
	{
		return -1;
	}
	
	public boolean ParkVehicle(Vehicle vehicle)
	{
		this._availableSpots--;
		return true;
	}
	
	public void SpotFreed()
	{
		this._availableSpots++;
	}
	
}
