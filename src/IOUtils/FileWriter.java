package IOUtils;

import java.io.*;

public class FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Read(String filepath) {
	
		String directory = System.getProperty("user.home");
		String fileName = filepath + "/" + "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// read the content from file
		try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(absolutePath))) {
		    int ch = bufferedInputStream.read();
		    while(ch != -1) {
		        System.out.print((char)ch);
		        ch = bufferedInputStream.read();
		    }
		} catch (FileNotFoundException e) {
		    // exception handling
		} catch (IOException e) {
		    // exception handling
		}
		
	}
	

	public void Write(String filepath) {
	
		String directory = System.getProperty("user.home");
		String fileName = filepath + "/" + "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// write the content in file 
		try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(absolutePath))) {
		    String fileContent = "This is a sample text.";
		    bufferedOutputStream.write(fileContent.getBytes());
		} catch (IOException e) {
		    // exception handling
		}
		
	}

}
