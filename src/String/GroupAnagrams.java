package String;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
	    List<List<String>> res = groupAnagrams1(input);
	    System.out.println(res.toString());
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];        
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
	
	//O(N*M)
	public static List<List<String>> groupAnagrams1(String[] strs)
	{
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		
		for(String str : strs)
		{
			char[] arr = new char[26];
			char[] ch = str.toCharArray();
			//Arrays.sort(ch);
			for(int i=0;i<str.length();i++)
			{
				arr[str.charAt(i)-'a']++;
			} 
			String ns = new String(arr);
			if(map.containsKey(ns)) {
				map.get(ns).add(str);
				
			} else
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
				
			}
			
		}
		res.addAll(map.values());
		return res;
		
	}

}
