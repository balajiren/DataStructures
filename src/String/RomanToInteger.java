package String;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 int value = romanToInt("VVXM");
		 System.out.print(value);
		 String  val = intToRoman(76);
		 System.out.print(val);
	}
	
	 public static int romanToInt(String s) {
	        if (s == null || s.length() == 0) return 0;
	         
	        // create a hash table to store the dictorary
	        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
	        hashMap.put('I', 1);
	        hashMap.put('V', 5);
	        hashMap.put('X', 10);
	        hashMap.put('L', 50);
	        hashMap.put('C', 100);
	        hashMap.put('D', 500);
	        hashMap.put('M', 1000);
	         
	        int num = 0;
	         
	        for (int i = 0; i < s.length(); i++) {
	            if (i <= s.length() - 2 && 
	                hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
	                num -= hashMap.get(s.charAt(i));
	            } else {
	                num += hashMap.get(s.charAt(i));
	            }
	        }
	        return num;
	    }
	 
	 public static String intToRoman(int num) {
	        String[] str = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	        int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	         
	        StringBuilder sb = new StringBuilder();
	         
	        for (int i = 0; i < val.length; i++) {
	            while (num >= val[i]) {
	                num -= val[i];
	                sb.append(str[i]);
	            }
	        }
	        return sb.toString();
	    }

}
