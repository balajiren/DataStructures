package String;
import java.util.*;

//https://leetcode.com/problems/brace-expansion/
//For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
public class BraceExpansion {
        public String[] expand(String S) {
            List<String> res = new ArrayList<>();
            res.add(S);
            while(res.get(0).contains("{")){
                int braceStartIndex = res.get(0).indexOf("{");
                int braceEndIndex = res.get(0).indexOf("}");
                System.out.println(braceStartIndex + " " + braceEndIndex);
                String options = res.get(0).substring(braceStartIndex+1, braceEndIndex);
                String[] optionsArray = options.split(",");
                List<String> temp = new ArrayList<>();
                for(String s : res){
                    for(String option : optionsArray){
                        String newString = s.substring(0,braceStartIndex) + option + s.substring(braceEndIndex+1);
                        temp.add(newString);
                    }
                }
                res = temp;
            }
            String[] resArray = new String[res.size()];
            for(int i = 0; i < resArray.length; i ++) resArray[i] = res.get(i);
            Arrays.sort(resArray);
            return resArray;
        }
}
