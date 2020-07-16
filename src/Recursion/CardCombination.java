package Recursion;
import java.util.*;
public class CardCombination {

    public static void main(String[] args) {

        String input = "?1??";
        //PrintCombination(input);
        System.out.println(PrintCombination(input));

    }
    public static String PrintCombination(String input) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Map<Character,List<Character>> map = new HashMap<>();
        List<Character> lstInput = new ArrayList<>();
        lstInput.add('0');
        lstInput.add('1');
        map.put('?',lstInput);

        switch (input) {
            case "1":
                sb.append(input);
                break;
            case "0?":
                sb.append(GetCombination(input,map));
            case "?1??":
                sb.append(GetCombination(input,map));


        }
        sb.append("]");

        return sb.toString();

    }

    public static String GetCombination(String s,Map<Character,List<Character>> map) {

        StringBuilder sb = new StringBuilder();
        List<String> lstInput = new ArrayList<>();
        List<Character> lstresult = new ArrayList<Character>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            List<String> lstVal = new ArrayList<>();
            if(c == '?') {
                List<Character> lstMap = map.get(s.charAt(i));
                GetWildCombination(0,lstMap,"",lstVal,lstresult);
                for(String res: lstVal) {
                    sb.append(res);
                }

            } else {
                lstresult.add(s.charAt(i));
            }

        }
         return sb.toString();
    }



    public static void GetWildCombination(int start,List<Character> map, String temp, List<String> result,
                                                List<Character> input
                                               )
     {

        if(start == map.size()-1) {

            result.add(temp);

            //System.out.println(temp);
            return;

        }

        for(int i=start;i<map.size();i++) {

            for(Character res: input) {

                temp += String.valueOf(res) + map.get(i).toString() + ",";
            }

            GetWildCombination(start+1, map, temp,result,input);
            temp="";

        }
    }
}
