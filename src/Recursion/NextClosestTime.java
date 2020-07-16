package Recursion;
import java.util.*;

public class NextClosestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String time  = "01:34";
		int hour = Integer.parseInt(time.substring(0,2));
		int minute = Integer.parseInt(time.substring(3,5));
		
		String result = nextClosestTime("01:20");
		System.out.println(result);
        //System.out.println(nextClosestTime("1:34"));
		

	}

    public static String nextClosestTime(String time) {
        Set<Character> initial = getAllChars(time);
        int hh = Integer.parseInt(time.substring(0, 2)), mm = Integer.parseInt(time.substring(3));
        String result = "";
        while (true) {
            mm += 1;
            if (mm == 60) {
                mm = 0;
                hh++;
            }
            if (hh == 24) {
                hh = 0;
                mm = 0;
            }
            String tmp = (hh < 10 ? "0" : "") + hh + ":" + (mm < 10 ? "0" : "") + mm;
            if (initial.containsAll(getAllChars(tmp))) {
                result = tmp;
                break;
            }
        }
        return result.isEmpty() ? time : result;
    }

    private static Set<Character> getAllChars(String time) {
        Set<Character> set = new HashSet<>();
        for (char c : time.toCharArray()) set.add(c);
        return set;
    }
	

}
