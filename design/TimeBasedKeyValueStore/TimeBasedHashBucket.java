package TimeBasedKeyValueStore;

import java.util.*;

import TimeBasedKeyValueStore.TimeBasedHashBucket.TimeValue;


public class TimeBasedHashBucket {
	
	
	public class TimeValue {
	    String value;
	    int timeStamp;
	
	    public TimeValue(String value, int timeStamp) {
	        this.value = value;
	        this.timeStamp = timeStamp;
	    }
	}
	
	static List<Pair<Integer, List<TimeValue>>> bucket;
	List<TimeValue> timeValues;

	TimeBasedHashBucket() {
		this.bucket =  new LinkedList<Pair<Integer,List<TimeValue>>>();
		this.timeValues = new ArrayList<TimeValue>();
	}
	
	
	public String get(Integer key, int timestamp) {
		List<Pair<Integer,List<TimeValue>>> values = this.bucket;
		for(Pair<Integer,List<TimeValue>> entry : values) {
			
			if(entry.first == key) {
				
				String val =  getClosest(entry.second, timestamp,0,entry.second.size()-1);
				return val;
			} 
		}
		return "";
	}
	
	private String getClosest(List<TimeValue> timeValues, int timeStamp, int low, int high) {
		if(low > high)
			return "";
		TimeValue val = timeValues.get(high);
		if(timeStamp >= val.timeStamp)
			return val.value;
		
		int mid = (low + high)/2;
		val = timeValues.get(mid);
		if(val.timeStamp == timeStamp)
			return val.value;
		
		if(mid > 0 && timeStamp >= timeValues.get(mid - 1).timeStamp && timeStamp < val.timeStamp)
			return timeValues.get(mid - 1).value;
		
		if(timeStamp < val.timeStamp)
			return getClosest(timeValues, timeStamp, low, mid - 1);
		return getClosest(timeValues, timeStamp, mid + 1, high);
	}
	
	public void Update(Integer key, int timeStamp, String value) {
		
		boolean isFound = false;
		for(Pair<Integer, List<TimeValue>> entry : this.bucket) {
			 
			if(entry.first == key) {
				TimeValue ts = new TimeValue(value,timeStamp);
				entry.second.add(ts);
				isFound = true;
				//entry.second = value;
			} 
		}
		if(!isFound) {
			
			List<TimeValue> values = new ArrayList<TimeValue>();
			values.add(new TimeValue(value,timeStamp));
			this.bucket.add(new Pair<Integer, List<TimeValue>>(key,values));
		}
		
	}
	
	public void remove(Integer key, String value) {
		
		for(Pair<Integer, List<TimeValue>> entry : this.bucket) {
			 
			if(entry.first == key) {
				this.bucket.remove(entry);
				break;
			} 
		}
		
	}
		

}
