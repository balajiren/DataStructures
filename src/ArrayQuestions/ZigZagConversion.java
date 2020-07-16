package ArrayQuestions;

import Common.Utils;

public class ZigZagConversion {

	public ZigZagConversion() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 String s = "PAYPALISHIRING";

	  String out =  ZigZagConvert(s,3);
	  Utils.PrintMessage(out);
	}
	
	
	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
	 
		StringBuilder sb = new StringBuilder();
		// step
		int step = 2 * numRows - 2;
	 
		for (int i = 0; i < numRows; i++) {
			//first & last rows
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					sb.append(s.charAt(j));
				}
			//middle rows	
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
	 
				while (j < s.length()) {
					sb.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
	 
		return sb.toString();
	}
	
	public static String ZigZagConvert(String s, int rows)
	{
		StringBuffer out = new StringBuffer();
		//char[] inputArray = s.toCharArray();
		int splitSize = s.length() / rows;
		char[] inputArray1 = s.substring(0, splitSize-1).toCharArray();
		char[] inputArray2 = s.substring(splitSize, splitSize * 2).toCharArray();
		char[] inputArray3 = s.substring(inputArray1.length + inputArray2.length, s.length()).toCharArray();
		
		for(int i=0;i<inputArray1.length;i++)
		{
			out.append(String.valueOf(inputArray1[i])+String.valueOf(inputArray2[i]));
		}
		for(int i=0;i<inputArray3.length;i++)
		{
			out.append(String.valueOf(inputArray3[i]));
		}
		
		return out.toString();
	}

}
