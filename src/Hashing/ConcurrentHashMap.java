package Hashing;

import java.util.Map;

public class ConcurrentHashMap {
	
	
	protected transient Entry[] table; 
	
	protected static class Entry implements Map.Entry {      
		   protected final Object key;
		   protected volatile Object value;
		   protected final int hash;
		   protected final Entry next;
		   Entry(int hash, Object key, Object value, Entry next) {
		     this.value = value;
		     this.hash = hash;
		     this.key = key;
		     this.next = next;
		   }
		   // Code goes here like getter/setter
		@Override
		public Object getKey() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getValue() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object setValue(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		 }
	
	protected static final class Segment {
		  protected int count;
		  protected synchronized int getCount() {
		    return this.count;
		  }
		  protected synchronized void synch() {}
		}
		/** Segment Array declaration **/
		public final Segment[] segments = new Segment[32];
		
		int threshold;
		int loadFactor;
		/*public ConcurrentHashMap(int initialCapacity, float loadFactor) {
			  //Some code
			  int cap 16);
			  this.table = newTable(cap); // here this.table is Entry[] table
			}
			protected Entry[] newTable(int capacity) {
			  this.threshold = ((int)(capacity * this.loadFactor / 32.0F) + 1);
			  return new Entry[capacity];
			}
		
			int hashVal = hash(key);
			static int hash(Object x) {
			  int h = x.hashCode();
			  return (h << 7) - h + (h >>> 9) + (h >>> 17);
			}
		
			synchronized (seg) {
				  // code to add
				  int index = hash & table.length - 1; // hash we have calculated for key and table is Entry[] table
				  Entry first = table[index];
				  for (Entry e = first; e != null; e = e.next) {
				    if ((e.hash == hash) && (eq(key, e.key))) { // if key already exist means updating the value
				      Object oldValue = e.value;
				      e.value = value;
				      return oldValue;
				    }
				  }
				  Entry newEntry = new Entry(hash, key, value, first); // new entry, i.e. this key not exist in map
				  table[index] = newEntry; // Putting the Entry object at calculated Index 
				}
		
		
		
			public Object get(Object key){
				  //some  code here
				  int index = hash & table.length - 1;  //hash we have calculated for key and calculating index with help of hash
				  Entry first = table[index];          //table is Entry[] table
				  for (Entry e = first; e != null; e = e.next) {
				    if ((e.hash == hash) && (eq(key, e.key))) {
				      Object value = e.value;
				      if (value == null) {
				        break;
				      }
				      return value;
				    }
				  }
				  //some  code here
				}
			
			
			Object remove(Object key, Object value) {
				  Segment seg = segments[(hash & 0x1F)]; //hash we have calculated for key
				  synchronized (seg) {
				    Entry[] tab = this.table; //table is Entry[] table    
				    int index = hash & tab.length - 1; //calculating index with help of hash
				    Entry first = tab[index]; //Getting the Entry Object
				    Entry e = first;
				    while(true) {
				      if ((e.hash == hash) && (eq(key, e.key))) {
				        break;
				      }
				      e = e.next;
				    }
				    Object oldValue = e.value;
				    Entry head = e.next;
				    for (Entry p = first; p != e; p = p.next) {
				      head = new Entry(p.hash, p.key, p.value, head);
				    }
				    table[index] = head;
				    seg.count -= 1;
				  }
				  return oldValue;
				}  */
		

		
		
		
		
		
		

}
