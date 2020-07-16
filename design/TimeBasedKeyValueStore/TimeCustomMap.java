package TimeBasedKeyValueStore;

import java.util.*;

public class TimeCustomMap<T> {
	
	List<TimeBasedHashBucket> hash_table;	
	int key_space;
	TimeCustomMap() {
		hash_table = new ArrayList<TimeBasedHashBucket>();
		this.key_space=2069;
		 for (int i = 0; i < this.key_space; ++i) {
		      this.hash_table.add(new TimeBasedHashBucket());
		  }

	}
	
	public int getHashPosition(Integer key) {
		return key.hashCode() % this.key_space;
	}
	
	public void put(Integer key, int timestamp, String value) {
		
		int hashCode = key.hashCode();
		int hashPosition = hashCode % this.key_space;
		this.hash_table.get(hashPosition).Update(key, timestamp,value);
		
	}
	
    public String get(Integer key, int timestamp) {
		return this.hash_table.get(getHashPosition(key)).get(key,timestamp);
	} 
    
    public void remove(Integer key) {
    	int hashPos = getHashPosition(key);
    	this.hash_table.get(hashPos);
    
    	
    }

}
