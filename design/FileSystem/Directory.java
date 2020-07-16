package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

	protected ArrayList<Entry> contents;
	
	public Directory(String n) {
		
		super(n,null);
		contents =new ArrayList<Entry>();
	}
	public Directory(String n, Directory p) {
		// TODO Auto-generated constructor stub
		super(n,p);
		contents =new ArrayList<Entry>();
		
	}
	
	public void getFullPath()
	{
		super.getFullFilePath();
		
	}
	public void DeleteEntry(Entry entry)
	{
		contents.remove(entry);
	}
	public void addEntry(Entry entry)
	{
		contents.add(entry);
	}
	public List<Entry> listFiles()
	{
		return contents;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size =0;
		for(Entry e : contents)
		{
			size+=e.size();
		}
		return size;
	}
	
	public boolean isDirectory()
	{
		return true;
	}

}
