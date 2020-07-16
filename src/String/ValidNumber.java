package String;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isNumber(String s) {
        int start = 0, end = s.length() -1;
        boolean dot = false, exp = false, digit = false;
        while (start <= end && (s.charAt(start) == ' ')) ++start;
        while (start <= end && (s.charAt(end) == ' ')) --end;
        if (start <= end && (s.charAt(start) == '+' || s.charAt(start) == '-')) ++start;
        if (start > end) return false;
        for ( ; start <= end; ++start) {
            if (Character.isDigit(s.charAt(start))) digit = true;
            else if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {
                if (exp == true || digit == false || start == end) return false;
                exp = true;
            } else if (s.charAt(start) == '.') {
                if (dot == true || exp == true) return false;
                if (digit == false && start == end) return false;
                dot = true;
            } else if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                if (start == end) return false;
                if (s.charAt(start-1) != 'e' && s.charAt(start-1) != 'E') return false;
            } else return false;
        }
        return true;
    }
	
	 public boolean isNumber1(String s) {
	        int i = 0;
	        int n = s.length();
	         
	        // step 1: skip leading white spaces
	        while (i < n && s.charAt(i) == ' ') {
	            i++;
	        }
	         
	        // step 2: Skip + or - sign
	        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
	            i++;
	        }
	         
	        boolean isNumeric = false;
	        // step 3: skip the first segement of numeric characters
	        while (i < n && Character.isDigit(s.charAt(i))) {
	            i++;
	            isNumeric = true;
	        }
	         
	        // step 4 and 5 skip the . character and the following numeric characters, if any
	        if (i < n && s.charAt(i) == '.') {
	            i++;
	            while (i < n && Character.isDigit(s.charAt(i))) {
	                i++;
	                isNumeric = true;
	            }
	        }
	         
	        // step 6 and 7 and 8, exponent character and following numeric characters
	        if (isNumeric && i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
	            i++;
	            isNumeric = false;
	            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
	                i++;
	            }
	            while (i < n && Character.isDigit(s.charAt(i))) {
	                i++;
	                isNumeric = true;
	            }
	        }
	        // step 9: Remove trailing white spaces
	        while (i < n && s.charAt(i) == ' ') {
	            i++;
	        }
	         
	        return isNumeric && i == n;
	    }

}
