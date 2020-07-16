package DFS;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decode();

	}
	
	public static String Decode() {
		
		StringBuilder sb = new StringBuilder();
		String result  = decodeString("3[a]2[bc]");
		System.out.print(result);
		return result;
		
	}
	
	public static String decodeString(String s) {
		StringBuffer result = new StringBuffer();
		int currentInt = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) >= '0' && s.charAt(i)<='9') {
				currentInt = currentInt*10 + (s.charAt(i)-'0');
			} else if(s.charAt(i) == '[') {
				int count =1;
				i++;
				StringBuffer sb = new StringBuffer();
				while(count!=0) {
					if(s.charAt(i) == '[') count++;
					if(s.charAt(i) == ']') count--;
					if(count!=0) sb.append(s.charAt(i++));
				}
				for(int j=0;j<currentInt;j++)
					result.append(decodeString(sb.toString()));
				currentInt = 0;
			} else result.append(s.charAt(i));
		}
		return result.toString();
	}

}
