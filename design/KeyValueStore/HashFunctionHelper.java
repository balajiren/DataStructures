package KeyValueStore;
import java.security.MessageDigest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

public class HashFunctionHelper {

	public  int hash(Object key) {
	    int h = 0;
	    for (char c : ((String) key).toCharArray())
	        h = (h * 37 + c) & 0xFFFFFFFF;
	    return h;
	}
	
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
	
	@SuppressWarnings("unused")
	public static String GethashString(String message)
	        throws Exception { 
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
	 
	        return convertByteArrayToHexString(hashedBytes);
	    } catch  (UnsupportedEncodingException ex) {
	        throw new Exception(
	                "Could not generate hash from String", ex);
	    }
	}
}
