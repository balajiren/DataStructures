package ParkingLot;

public class ParkingSpot {

	private Vehicle vehicle;
	private Level level;
	private int row;
	private int spotNumber;
	
	public ParkingSpot(Level lvl, int r, int n, int vehicleSize)
	{
		
		
	}
	
	public boolean IsAvailable()
	{
		return true;
		
	}
	
	public boolean park(Vehicle v)
	{
		return true;
	}
	
	public int getSpot(Vehicle v)
	{
		return 0;
	}
	
	public boolean removeVehicle(Vehicle v)
	{
		return true;
	}
}
