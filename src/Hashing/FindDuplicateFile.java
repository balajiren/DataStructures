package Hashing;

import java.util.*;


class File
{
	
	String _path;
	List<String> _directory;
	String _value;
	File(List<String> directory, String name, String value)
	{
		_directory = directory;
		_value = value;
		
	}
	
	public boolean IsDirectory()
	{
		return true;
	}
	
	public List<File> GetFiles()
	{
		return new ArrayList<File>();
	}
	public String GetFilePath(List<String> directory)
	{
		StringBuilder sb = new StringBuilder();
		for(String s : directory)
		{
			sb.append(s + "/");
			
	    }
		return sb.toString();
	}
	
}


public class FindDuplicateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		List<List<String>> resultSet = FindDuplicate(paths);
		for(List<String> res : resultSet)
		{
			System.out.println(Arrays.toString(res.toArray()));
		}
	}
	
	
	public static List<List<String>> FindDuplicate(String[] paths)
	{
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(String path : paths)
		{
			String[] values = path.split(" ");
			for(int i=1;i<values.length;i++)
			{
				    String value = values[i];
					String[] name_cont = value.split("\\(");
					name_cont[1] = name_cont[1].replace(")"," ");
					if(map.containsKey(name_cont[1]))
					{
						List<String> files = map.get(name_cont[1]);
						files.add(values[0]+"/"+name_cont[0]);
						map.put(name_cont[1], files);
						
						
					}
					else
					{
						
					    List<String> files = new ArrayList<String>();
					    files.add(values[0]+"/"+name_cont[0]);
						map.put(name_cont[1], files);
					
							
					}
			}
			
		}
			
		List<List<String>> res = new ArrayList< >();
		for(String key  : map.keySet())
		{
			if(map.get(key).size() > 1)
			{
				res.add(map.get(key));
			}
			
		}
		return res;
		
	
	}
}
	


