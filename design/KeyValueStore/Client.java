package KeyValueStore;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashFunctionHelper func = new HashFunctionHelper();
		String hashedValue;
		try {
			hashedValue = HashFunctionHelper.GethashString("test");
			System.out.println(hashedValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
