package TimeBasedKeyValueStore;

import java.util.*;

public class CustomMap<T> {
	
	List<HashBucket> hash_table;	
	int key_space;
	CustomMap() {
		hash_table = new ArrayList<HashBucket>();
		this.key_space=2069;
		 for (int i = 0; i < this.key_space; ++i) {
		      this.hash_table.add(new HashBucket());
		  }

	}
	
	public int getHashPosition(Integer key) {
		return key.hashCode() % this.key_space;
	}
	
	public void put(Integer key, String value) {
		
		int hashCode = key.hashCode();
		int hashPosition = hashCode % this.key_space;
		this.hash_table.get(hashPosition).Update(key, value);
		
	}
	
    public String get(Integer key) {
		return this.hash_table.get(getHashPosition(key)).get(key);
	} 
    
    public void remove(Integer key) {
    	int hashPos = getHashPosition(key);
    	this.hash_table.get(hashPos);
    
    	
    }

}
