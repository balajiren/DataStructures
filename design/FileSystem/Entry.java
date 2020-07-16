package FileSystem;

import java.util.List;

public abstract class Entry
{
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;
	
	Entry(String n, Directory p)
	{
		name  = n;
		parent = p;
	}
	
	public abstract int size();
	public String getFullFilePath()
	{
		if(parent == null)
		{
			//System.out.print( "/" + name);
			return null;
		}
		System.out.print(parent.getFullFilePath() == null ?  "/" + name :  parent.getFullFilePath()+ "/" + name);
		return parent.getFullFilePath() + "/" + name;	
			
	}
	
	public boolean isDirectory()
	{
		return false;
	}

	public List<Entry> listFiles()
		{
			return null;
		}
	
	
	
}
