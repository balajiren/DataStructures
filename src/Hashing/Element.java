package Hashing;

import java.security.Timestamp;
import java.util.Date;

public class Element {
	
	
	
	public String value;
	
	public Date time;
	
	
	public String getValue()
	{
		
		return value;
		
	}
	
	public String getTimestamp()
	{
		
		return time.toString();
		
	}
	
	public void setTimestamp(Date t)
	{
		
		time = t;
		
	}
	
	public void setValue(String t)
	{
		
		value = t;
		
	}
	
	
	
	

}
