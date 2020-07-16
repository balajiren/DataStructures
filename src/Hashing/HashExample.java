package Hashing;
import java.util.*;
//
//public class HashExample {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	
//
//}
//
//
///*
//* Given the list of boarding passess:
//* NYC -> MCO
//* PHX -> NYC
//* SFO -> PHX
//*
//* final trip
//* "SFO —> PHX ---> NYC ---> MCO"
//*/
//
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
public class HashExample {
    public static void main(String args[] ) throws Exception {
    	HashExample sol = new HashExample();
        List<String> lstPass = new ArrayList<String>();
        lstPass.add("NYC");
        lstPass.add("MCO");
        List<String> lstPass1 = new ArrayList<String>();
        lstPass1.add("PHX");
        lstPass1.add("NYC");
        List<String> lstPass2 = new ArrayList<String>();
        lstPass2.add("SFO");
        lstPass2.add("PHX");
        List<List<String>> lstPasses = new ArrayList<List<String>>();
        lstPasses.add(lstPass);
        lstPasses.add(lstPass1);
        lstPasses.add(lstPass2);
        System.out.println(sol.GetIterninarary(lstPasses));
    }

    //1. Represent the location as graph node
    //2. Have a datastructure to track the order of itenirary
    //3. Travel the graph and print based on the order
    public String GetIterninarary(List<List<String>> passes) {
        //boundary
        if(passes.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
         //* NYC -> MCO
        // * PHX -> NYC
        // * SFO -> PHX
        Map<String,String> passMap = new HashMap<String,String>();
        List<String> sources  = new ArrayList<String>();
        String startLocation = "";
        
        //O(N)
        int length = passes.size();
        int index=0;
        for(List<String> lstPass:  passes) {
        	
            String from = lstPass.get(0);
            String to = lstPass.get(1);
           // sources.add(from);
  
            passMap.put(from,to);
//            if(index == length-1) {
//            	if(passMap.containsValue(from)) {
//            		sb.append(from);
//                	startLocation = from;
//                }
//            }
            
            index++;

        }
        //System.out.println(passMap);
      
//        //Iterate the sources to check whether there is a to location
//        //O(n)
        for(String from : passMap.keySet()) {
            if(!passMap.containsValue(from)) {
                sb.append(from);
                startLocation=from;
            }
        }
        
        
        //Iterate the locations
        while(true) {
            if(passMap.containsKey(startLocation)) {
                String toLocation = passMap.get(startLocation);
                sb.append("-->"+toLocation);
                startLocation=toLocation;
            } else {
                break;
            }
            
        }
        return sb.toString();
        
    }
    
}
