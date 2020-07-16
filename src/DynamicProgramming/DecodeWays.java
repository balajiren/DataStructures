package DynamicProgramming;
import java.util.*;

public class DecodeWays {

    HashMap<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {

        //boundary
        if(s == null) {
            return 0;
        }
        return recursiveWithMemo(0,s);

    }


    public int recursiveWithMemo(int index, String input) {


        if(index == input.length()) {
            return 1;
        }

        if(input.charAt(index) == '0') {
            return 0;
        }


        if (index == input.length()-1) {
            return 1;
        }

        if(memo.containsKey(index)) {
            return memo.get(index);
        }

        int ans = recursiveWithMemo(index+1,input);
        if(Integer.parseInt(input.substring(index,index+2)) <=26) {
            ans+=recursiveWithMemo(index+2, input);
        }
        memo.put(index,ans);

        return ans;
    }
}
