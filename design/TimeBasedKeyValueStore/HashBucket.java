package TimeBasedKeyValueStore;

import java.util.LinkedList;
import java.util.List;

class Pair<U, V> {
	  public U first;
	  public V second;

	  public Pair(U first, V second) {
	    this.first = first;
	    this.second = second;
	  }
	}




public class HashBucket {
	
	List<Pair<Integer,String>> bucket;

	HashBucket() {
		this.bucket =  new LinkedList<Pair<Integer,String>>();
	}
	
	
	public String get(Integer key) {
		for(Pair<Integer, String> entry : this.bucket) {
			 
			if(entry.first == key) {
				return entry.second;
			} 
		}
		return "";
	}
	
	public void Update(Integer key, String value) {
		
		boolean isFound = true;
		for(Pair<Integer, String> entry : this.bucket) {
			 
			if(entry.first == key) {
				entry.second = value;
			} 
		}
		if(!isFound) {
			this.bucket.add(new Pair(key,value));
		}
		
	}
	
	public void remove(Integer key) {
		
		for(Pair<Integer, String> entry : this.bucket) {
			 
			if(entry.first == key) {
				this.bucket.remove(entry);
				break;
			} 
		}
		
	}
		

}
