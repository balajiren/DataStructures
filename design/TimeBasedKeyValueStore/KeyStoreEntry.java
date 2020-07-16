package TimeBasedKeyValueStore;

public class KeyStoreEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testkeymap();
	}
	
	public static void testkeymap() {
//		TimeMap map = new TimeMap();
//		map.set("foo","bar",1);
//		map.set("foo","bar2",4);
//		System.out.print(map.get("foo",4));
		
		//System.out.print("TEST");
		
		try {
			TimeCustomMap map = new TimeCustomMap();
			map.put(1, 1, "bar");
			map.put(1, 4, "bar");
			map.put(1, 6, "bar2");
			System.out.print(map.get(1, 5));
		}  
		catch(Exception ex) {
			System.out.print(ex);
		}
	}

}
	