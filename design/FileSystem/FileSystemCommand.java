package FileSystem;

public class FileSystemCommand implements ICommand {

	private Directory currentDir;
	public FileSystemCommand(Directory dir) {
		// TODO Auto-generated constructor stub
		currentDir = dir;
	}

	@Override
	public void Execute(String Request) {
		// TODO Auto-generated method stub
		
		switch(Request)
		{
		  case "ls -l":
			 currentDir.getFullPath();
			break;
		  case "pwd":
			 currentDir.getFullPath();
			break;
		
		
		
		}
		
	}

}
