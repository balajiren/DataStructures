package IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class nioWriter {
	
	
	
	public void read() {
		
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";

		String content = "This is a sample text.";
		Path path = Paths.get(directory, fileName);

		try {
		    Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
		    // exception handling
		}

		try {
		    List<String> list = Files.readAllLines(path);
		    list.forEach(line -> System.out.println(line));
		} catch (IOException e) {
		    // exception handling
		}
	}

}
