package ValletParking;

public class Vehicle {
	
	
	public String registration;
	public VehicleSize Size;
	
	Vehicle(String _registration,VehicleSize _size)
	{
		registration = _registration;
		Size = _size;
	}
	
	public enum VehicleSize
	{
		SMALL (1),
		MEDIUM (2),
		LARGE  (3);
		private final int vehicleSize;
		VehicleSize(Integer _size)
		{
			vehicleSize = _size;
			
		}
		
	}

}
