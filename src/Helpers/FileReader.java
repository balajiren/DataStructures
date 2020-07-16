package Helpers;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class FileReader implements IReader {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ReadFile("./Files/sample.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} */
	
	public String ReadFile(String filePath) throws IOException
	{
		StringBuilder builder = new StringBuilder();
		try
		{
			Reader in  = new java.io.FileReader(filePath);
			BufferedReader br = new BufferedReader(in);
			String line = null;

			while((line = br.readLine()) != null)
			{
				builder.append(line);
			}
		
		}
		catch(IOException ex)
		{
			
		}
		return builder.toString();
		
	}
	
	public static void writeFile() throws IOException {
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (int i = 0; i < 10; i++) {
			bw.write("something");
			bw.newLine();
		}
	 
		bw.close();
	} 
	
	public static void splitFile(File f) throws IOException {
        int partCounter = 1;//I like to name parts from 001, 002, 003, ...
                            //you can change it to 0 if you want 000, 001, ...

        int sizeOfFiles = 1024 * 1024;// 1MB
        byte[] buffer = new byte[sizeOfFiles];

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(f))) {//try-with-resources to ensure closing stream
            String name = f.getName();

            int tmp = 0;
            while ((tmp = bis.read(buffer)) > 0) {
                //write each chunk of data into separate file with different number in name
                File newFile = new File(f.getParent(), name + "."
                        + String.format("%03d", partCounter++));
                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(buffer, 0, tmp);//tmp is chunk size
                }
            }
        }
    }
	
	public static void mergeFiles(List<File> files, File into)
	        throws IOException {
	    try (BufferedOutputStream mergingStream = new BufferedOutputStream(
	            new FileOutputStream(into))) {
	        for (File f : files) {
	            Files.copy(f.toPath(), mergingStream);
	        }
	    }
	}

}
