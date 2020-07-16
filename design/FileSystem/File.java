package FileSystem;

public class File extends Entry {

	private String content;
	private int size;
	private Directory directory;
	public File(String name, Directory dir, int sz) {
		// TODO Auto-generated constructor stub
		super(name,dir);
		size = sz;
		directory= dir;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String GetContent()
	{
		return content;
	}
	
	public void SetContent(String con)
	{
		content = con;
	}
	
	public String GetPath()
	{
		return directory.getFullFilePath();
	}
	
	public boolean isDirectory()
	{
		return false;
	}

}
