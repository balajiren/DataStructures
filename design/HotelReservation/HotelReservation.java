package HotelReservation;

import java.sql.Date;
import java.util.Hashtable;
import java.util.Random;

public class HotelReservation {
	
	long _reservationId;
	Hashtable<Long, Reservation> reservations = new Hashtable<Long, Reservation>();
	
	HotelReservation(String firstName, String lastName, long startTime, long endTime, int partySize)
	{
		Person reserver = new Person();
		reserver.firstName = firstName;
		reserver.lastName = lastName;
		Random random = new Random();
		_reservationId = random.nextLong();
			
		reservations.put(_reservationId, new Reservation(_reservationId, startTime, reserver,partySize));
		
		
		
	}
	
	public Reservation GetReservation(long reservationId)
	{
		
		return reservations.get(reservationId);
	}
	
	
	
	
	class Person
	{
		String firstName;
		String  lastName;
		
	}
	
    class Reservation
    {
    	long reservationID;
    	Date startDate;
    	Date endDate;
    	Person _reservor;
    	long startTime;
    	long endTime;
    	int _partySize;
    	
    	public Reservation( long reservationID, long startTime, Person reserver, int partySize){
    		this.startTime = startTime;
    		this._reservor = reserver;
    		this._partySize = partySize;
    		}
    	
    	
    	
    }
}
