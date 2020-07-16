package FileSystem;

import java.util.Iterator;
import java.util.TreeSet;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Directory dir = new Directory("BALAJI",new Directory("Root"));
		dir.addEntry(new File("FILE1",dir,1));
        ICommand cmd = new FileSystemCommand(dir);
        cmd.Execute("pwd");
       // java.util.TreeSet<String> set = new TreeSet<>(comparator)
       

	}

}
