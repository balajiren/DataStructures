package InMemoryDatabase;

import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.io.*;

public class TransationLogSerializer {
	
	private static String TRANSACTION_LOG_FILE = "log.txt";
	
	public static void main(String args[]) throws IOException
	{
		WriteToFile("test", "testdata", 0);
		ReadDataFromFile(TRANSACTION_LOG_FILE);
		
	}
	
	private static String GetCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}
	
	public static String ReadDataFromFile(String path) throws IOException
	{
		StringBuilder b = new StringBuilder();
		 // variable declaration
        int ch;
 
        // check if File exists or not
        java.io.FileReader fr=null;
        try
        {
            fr = new java.io.FileReader(TRANSACTION_LOG_FILE);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
        	b.append((char)ch);
           // System.out.print((char)ch);
 
        // close the file
        System.out.println(b.toString());
        fr.close();
        return b.toString();
	}
	
	public static void WriteToFile(String key, String value, int version) throws IOException
	{
		String text = String.format("%s %s %s %s", GetCurrentDate(),version, key, value);
        BufferedWriter output = null;
        try {
            File file = new File(TRANSACTION_LOG_FILE);
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
        
	}
	
	public static  void SerializeHashTable(HashMap<String, Integer> hmap)
	{
		 try
         {
                FileOutputStream fos =
                   new FileOutputStream("hashmap.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(hmap);
                oos.close();
                fos.close();
                System.out.printf("Serialized HashMap data is saved in hashmap.ser");
         }catch(IOException ioe)
          {
                ioe.printStackTrace();
          }
	}
	
	
	public static HashMap<Integer, String> DeSerializeHashMap()
	{
		HashMap<Integer, String> map = null;
	      try
	      {
	         FileInputStream fis = new FileInputStream("hashmap.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         map = (HashMap) ois.readObject();
	         ois.close();
	         fis.close();
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return null;
	      }
	      return map;
	}

}
