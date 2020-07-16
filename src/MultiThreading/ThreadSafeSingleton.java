package MultiThreading;

public class ThreadSafeSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static final Object instance = null;
	
	public static Object getInstance() {
		return instance;
	}

}


/*public static CrunchifySingleton getInstance() {
	if (instance == null) {
		// Thread Safe. Might be costly operation in some case
		synchronized (CrunchifySingleton.class) {
			if (instance == null) {
				instance = new CrunchifySingleton();
			}
		}
	}
	return instance;
} */