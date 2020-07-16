package ValletParking;

public class ParkingSpot {

	public String spotCode;
	public ParkingSpotSize Size;
	
	ParkingSpot(String _spotCode,ParkingSpotSize _size)
	{
		_spotCode = spotCode;
		Size = _size;
	}
	
	public enum ParkingSpotSize
	{
		SMALL (1),
		MEDIUM (2),
		LARGE  (3);
		private final int spotSize;
		ParkingSpotSize(Integer _size)
		{
			spotSize = _size;
			
		}
		
	}
	
}
