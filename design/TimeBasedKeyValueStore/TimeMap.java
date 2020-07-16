package TimeBasedKeyValueStore;
import java.util.*;


public class TimeMap {
	

	public class TimeValue {
	    String value;
	    int timeStamp;
	
	    public TimeValue(String value, int timeStamp) {
	        this.value = value;
	        this.timeStamp = timeStamp;
	    }
	}
		
	private Map<String, List<TimeValue>> timemap;
    /** Initialize your data structure here. */
    public TimeMap() {
    	timemap = new LinkedHashMap<>();
    	//timemap = new CustomMap<>();
    }
    public void set(String key,String value, int timestamp) {
    	
    	if(!timemap.containsKey(key)) {
    		List<TimeValue> lstValues = new ArrayList<TimeValue>();
    		lstValues.add(new TimeValue(value,timestamp));
    		timemap.put(key, lstValues);
    		
    	} else {
    		timemap.get(key).add(new TimeValue(value,timestamp));
    	}
    	
    }

    public String get(String key, int timestamp) {
    	
    	List<TimeValue> timeValues = timemap.get(key);
    	return getClosest(timeValues, timestamp,0,timeValues.size()-1);
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
    
    

}
