package Hashing;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
public class RecursiveFileDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void FindDuplicate(Map<String,List<String>> lists,File directory ) throws IOException
	{
		
		for(File child : directory.GetFiles())
		{
			
			if(child.IsDirectory())
			{
				FindDuplicate(lists,child);
			} 
			else
			{
				FileInputStream stream = new FileInputStream(child._path);
				byte fileData[] = new byte[(int) 100];
				stream.read(fileData);
				stream.close();
				MessageDigest md = null;
				try {
					md = MessageDigest.getInstance("SHA-512");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String uniqueHash = new BigInteger(1, md.digest(fileData)).toString(16);
				List<String> list = lists.get(uniqueHash);
				if(list == null)
				{
					list = new ArrayList<String>();
					lists.put(uniqueHash, list);
					
					
				}
				
				list.add(child._path);
				
				
				
				
			}
			
		}
		
		
		
	}
	

}
